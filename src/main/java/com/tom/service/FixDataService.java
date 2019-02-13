package com.tom.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tom.dao.SelfMapper;
import com.tom.dao.generator.AttMapper;
import com.tom.dao.generator.AttendanceMapper;
import com.tom.model.generator.Att;
import com.tom.model.generator.Attendance;
import com.tom.model.generator.AttendanceExample;
import com.tom.util.DateUtil;

@Service("fixDataService")
public class FixDataService
{
    @Autowired
    private AttendanceMapper attendanceMapper;
    @Autowired
    private AttMapper attMapper;
    @Autowired
    private SelfMapper selfMapper;
    
    public void fixData() throws ParseException {
        //获取员工工号列表
        List<Map<String, Object>> staffNoList = selfMapper.getStaffNo();
        for(Map<String, Object> staffNoMap:staffNoList) {
            //遍历员工
            Integer staffNo=(Integer)staffNoMap.get("staff_no");
            String name=staffNoMap.get("name").toString();
            String dept=staffNoMap.get("dept").toString();
            //遍历时间
            List<Date> result = new ArrayList<Date>();
            Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-01");//定义起始日期
            Date d2 = new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-31");//定义结束日期
            Calendar dd = Calendar.getInstance();//定义日期实例
            dd.setTime(d1);//设置日期起始时间
            while(dd.getTime().before(d2)){//判断是否到结束日期
                //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                //String str = sdf.format(dd.getTime());
                result.add(dd.getTime());
                dd.add(Calendar.DAY_OF_MONTH, 1);
            }
            //SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            //String str1 = sdf1.format(d2.getTime());
            result.add(d2);
            for(Date date:result) {
                AttendanceExample attendanceExample = new AttendanceExample();
                attendanceExample.createCriteria()
                    .andAttendanceTimeBetween(DateUtil.dayStart(date), DateUtil.dayEnd(date))
                    .andStaffNoEqualTo(staffNo);
                attendanceExample.setOrderByClause(" attendance_time asc ");
                List<Attendance> attendances = attendanceMapper.selectByExample(attendanceExample);
                if(attendances.size()>0) {
                   Att att = new Att();
                   att.setDept(dept);
                   att.setName(name);
                   att.setStaffNo(staffNo);
                   //上午上班时间
                   Attendance attendance = attendances.get(0);//第一条打卡记录
                   if(attendance.getAttendanceTime().before(
                           DateUtil.setDate(attendance.getAttendanceTime(), 12, 0))) {
                       //在12点前打卡设置为打卡时间
                       att.setTime1(attendance.getAttendanceTime());
                   }else {
                       //12点后打卡默认8点钟打卡
                       att.setTime1(DateUtil.setDate(attendance.getAttendanceTime(), 8, 0));
                   }
                   //中午下班时间
                   for(Attendance attendance2:attendances) {
                       if(DateUtil.setDate(attendance2.getAttendanceTime(), 12, 0)
                               .before(attendance2.getAttendanceTime())
                               &&attendance2.getAttendanceTime().before(
                                       DateUtil.setDate(attendance2.getAttendanceTime(), 12, 15))) {
                           //12:00-12:15打卡
                           att.setTime2(attendance2.getAttendanceTime());
                       }
                   }
                   if(att.getTime2()==null) {
                       //补时间
                       att.setTime2(DateUtil.setDate(attendance.getAttendanceTime(), 12, 0));
                   }
                   //下午上班时间
                   for(Attendance attendance3:attendances) {
                       if(DateUtil.setDate(attendance3.getAttendanceTime(), 12, 15)
                               .before(attendance3.getAttendanceTime())
                               &&attendance3.getAttendanceTime().before(
                                       DateUtil.setDate(attendance3.getAttendanceTime(), 13, 31))) {
                           //12:15-13:30打卡
                           att.setTime3(attendance3.getAttendanceTime());
                           break;
                       }
                   }
                   if(att.getTime3()==null) {
                       //补时间
                       att.setTime3(DateUtil.setDate(attendance.getAttendanceTime(), 13, 30));
                   }
                   //下午下班时间
                   Attendance attendance4 = attendances.get(attendances.size()-1);//最后一条打卡记录
                   
                   if(DateUtil.setDate(attendance4.getAttendanceTime(), 17, 30).before(
                           attendance4.getAttendanceTime())) {
                       //17:30后有打卡记录
                       att.setTime4(attendance4.getAttendanceTime());
                   }else {
                       //默认17:30
                       att.setTime4(DateUtil.setDate(attendance4.getAttendanceTime(), 17, 30));
                   }
                   attMapper.insert(att);
                }
            }
        }
        
    }
    
    
}
