package com.tom.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 时间、字符串处理类
 * @since 2017-10-30 16:08:37
 */
public class DateUtil {
	private static SimpleDateFormat mon = new SimpleDateFormat("yyyy-MM");
	private static SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat daySimple = new SimpleDateFormat("yyyyMMdd");
	private static SimpleDateFormat sec = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private static SimpleDateFormat all = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat smooth = new SimpleDateFormat("yyyyMMddHHmmss");
	private static SimpleDateFormat smoothMilli = new SimpleDateFormat("yyyyMMddHHmmssSSS");

	/**
	 * 年月
	 * @return yyyy-MM
	 */
	public static String getMonth() {
		Date date = new Date();
		String d = mon.format(date);
		return d;
	}

	/**
	 * 年月日
	 * @return yyyy-MM-dd
	 */
	public static String getDate() {
		Date date = new Date();
		String d = day.format(date);
		return d;
	}
	
	/**
	 * 获取年月日
	 * @return yyyyMMdd
	 */
	public static String getDaySimple() {
		Date date = new Date();
		String d = daySimple.format(date);
		return d;
	}
	
	/**
	 * 获取年月日时分
	 * @return yyyy-MM-dd HH:mm
	 */
	public static String getSeconds() {
		Date date = new Date();
		String d = sec.format(date);
		return d;
	}
	
	/**
	 * 获取年月日时分秒
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getALLTime() {
		Date date = new Date();
		String d = all.format(date);
		return d;
	}
	
	/**
	 * 根据时间戳获取年月日时分秒
	 * @param timestamp
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getALLTime(Long timestamp) {
		Date date = new Date(timestamp * 1000);
		String d = all.format(date);
		return d;
	}

	/**
	 * @param date
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getALLTime(Date date) {
		String d = all.format(date);
		return d;
	}

	/**
	 * 自定义日期类型
	 * @param format
	 * @return
	 */
	public static String getDate(String format) {
		SimpleDateFormat dataFormat = new SimpleDateFormat(format);
		Date date = new Date();
		String d = dataFormat.format(date);
		return d;
	}

	/**
	 * 字符串日期格式转Date类型
	 * @param strDate（yyyyMMddHHmmss）
	 * @return 
	 */
	public static Date getSmoothTime(String strDate) {
		java.util.Date ret = null;
		try {
			ret = smooth.parse(strDate);
		} catch (Exception e) {
			System.out.println("~~~~~字符串转换日期时发生了异常~~~~~");
		} finally {

		}
		return ret;
	}
	
	/**
	 * 字符串日期格式转Date类型
	 * @param strDate（yyyy-MM-dd HH:mm:ss）
	 * @return 
	 */
	public static Date getAllTime(String strDate) {
		java.util.Date ret = null;
		try {
			ret = all.parse(strDate);
		} catch (Exception e) {
			System.out.println("~~~~~字符串转换日期时发生了异常~~~~~");
		} finally {
			
		}
		return ret;
	}
	
	/**
	 * 获取当前星期几
	 * @param date
	 * @return
	 */
	public static String getWeekOfDate(Date date) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
	/**
	 * 获取年月日时分秒
	 * @return yyyyMMddHHmmss
	 */
	public static String getSmoothTime() {
		Date date = new Date();
		return smooth.format(date);
	}
	
	/**
	 * 获取年月日时分秒毫秒
	 * @return yyyyMMddHHmmssSSS
	 */
	public static String getSmoothMilliTime() {
		Date date = new Date();
		return smoothMilli.format(date);
	}
	

	/**
	 * 判断当前时间在否在给定两个时间之前
	 * @param star
	 * @param end
	 * @return
	 */
	public static boolean date_range(String star,String end){
		SimpleDateFormat localTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		try{
			Date sdate = localTime.parse(star+" 00:00:01");
			Date edate=localTime.parse(end+" 23:59:59");
			long time = new Date().getTime();
			return (time>=sdate.getTime()&& time<=edate.getTime());
		}catch(Exception e){
			return false;
		}
	}
	
	/**
	 * 判断当前时间断是否给定两个时间断之间
	 * @param star
	 * @param end
	 * @return
	 */
	public static boolean time_range(String star,String end){
		SimpleDateFormat localTime=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat localTime1=new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		String now = localTime.format(new Date());
		//System.out.println(now);
		try{
			Date sdate = localTime1.parse(now+" "+star+":00");
			Date edate=localTime1.parse(now+" "+end+":59");
			Date nowDate = localTime1.parse(now +" "+ getALLTime().split(" ")[1]);
			return (nowDate.getTime()>=sdate.getTime()&& nowDate.getTime()<=edate.getTime());
		}catch(Exception e){
			return false;
		}
	}
	public static void main(String[] args) throws Exception{
	    List<String> result = new ArrayList<String>();
        Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-01");//定义起始日期
        Date d2 = new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-31");//定义结束日期
        Calendar dd = Calendar.getInstance();//定义日期实例
        dd.setTime(d1);//设置日期起始时间
        while(dd.getTime().before(d2)){//判断是否到结束日期
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String str = sdf.format(dd.getTime());
            result.add(str);
            dd.add(Calendar.DAY_OF_MONTH, 1);
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String str1 = sdf1.format(d2.getTime());
        result.add(str1);
        for(String str:result) {
            System.out.println(str);
        }
	}
	/**
	 * 根据传入日期和推移天数获取推移的日期
	 * 返回日期格式为 yyyy-MM-dd hh:mm:ss
	 * @param begindate
	 * @return
	 */
	public static String getAnyNextDate(Date begindate,int day){
            String endDate = "";

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

            Calendar cal = Calendar.getInstance();
            cal.setTime(begindate);
            cal.add(Calendar.DAY_OF_MONTH, day);
            Date resultDate = cal.getTime();
             endDate = sdf.format(resultDate);
            return endDate;
    }
	
	/**
	 * 获取当天起始时间
	 * @return
	 */
	public static Date todayStart() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * 
	 * 概要说明 : 设置小时和分钟. <br>
	 * 详细说明 : TODO ADD Instruction. <br>
	 *
	 * @param date
	 * @param hour
	 * @param minute
	 * @return  Date 类型返回值说明
	 * @see  com.tom.util.DateUtil#setDate()
	 * @author  by Administrator @ 2019年2月13日, 下午4:17:23
	 */
	public static Date setDate(Date date,int hour,int minute) {
	    Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
	}
	
	/**
     * 获取当天起始时间
     * @return
     */
    public static Date dayStart(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
    /**
     * 获取当天结束时间
     * @return
     */
    public static Date dayEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }
	
	
	/**
	 * 获取当天时间
	 * @param hour  0-23
	 * @return
	 */
	public static Date todayStart(int hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * 获取本周起始时间
	 * @return
	 */
	public static Date weekStart() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	public static Date monthStart() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	public static Date yearStart() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	public static Date yearStart(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	public static Date allStart() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.YEAR, 2000);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

}
