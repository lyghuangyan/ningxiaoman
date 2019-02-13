package com.tom.util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

/**
 * 日期工具类
 * @author Administrator
 *
 */
public class TomDateUtil {
	
	/**
	 * 获取当日起始时间毫秒
	 * @return
	 */
	public static long getStartTime() {
		Calendar todayStart = Calendar.getInstance();
		todayStart.set(Calendar.HOUR_OF_DAY, 0);
		todayStart.set(Calendar.MINUTE, 0);
		todayStart.set(Calendar.SECOND, 0);
		todayStart.set(Calendar.MILLISECOND, 0);
		return todayStart.getTime().getTime();
	}
	
	/**
	 * 获取当日截止时间毫秒
	 * @return
	 */
	public static long getEndTime() {
		Calendar todayEnd = Calendar.getInstance();
		todayEnd.set(Calendar.HOUR_OF_DAY, 23);
		todayEnd.set(Calendar.MINUTE, 59);
		todayEnd.set(Calendar.SECOND, 59);
		todayEnd.set(Calendar.MILLISECOND, 999);
		return todayEnd.getTime().getTime();
	}

	/**
	 * 判断是否有资格评论
	 * @param date 上次评论时间
	 * @return
	 */
	public static boolean isAbleComment(Date date) {
		if(date == null) {
			//上次评论时间为空，有资格继续评论
			return true;
		}
		try {
			Date nowDate = new Date();
			if(nowDate.before(date)) {
				//当前时间在上次评论时间之前，没有资格继续评论
				return false;
			}
			Integer year = nowDate.getYear();
			Integer lastYear = year - 1;
			Date fDate = DateUtils.parseDate(lastYear+"0901", "yyyyMMdd");
			Date sDate = DateUtils.parseDate(year+"0301", "yyyyMMdd");
			Date tDate = DateUtils.parseDate(year+"0901", "yyyyMMdd");
			//Calendar.HOUR_OF_DAY
			if(date.before(fDate)) {
				//上次评论在去年九月份前
				return true;
			}
			if(fDate.before(date) && date.before(sDate)) {
				//上次评论在去年九月份到今年三月份之间
				if(nowDate.before(sDate)) {
					return false;
				} else {
					return true;
				}
			}
			if(sDate.before(date) && date.before(tDate)) {
				//上次评论在今年三月份到今年九月份之间
				if(nowDate.before(tDate)) {
					return false;
				} else {
					return true;
				}
			}
			if(tDate.before(date)) {
				//上次评论在今年九月份之后
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	
	/**
	 * 获取几分钟后时间
	 * @param minute
	 * @return
	 */
	public static Date beforeDateByMinute(Integer minute) {
		Calendar beforeTime = Calendar.getInstance();
		beforeTime.add(Calendar.MINUTE, minute);
		Date beforeD = beforeTime.getTime();
		return beforeD;
	}
	
	public static Date beforeDateByDay(Integer days) {
		Calendar beforeTime = Calendar.getInstance();
		beforeTime.add(Calendar.DATE, days);
		beforeTime.set(Calendar.HOUR, 0);
		beforeTime.set(Calendar.MINUTE, 0);
		beforeTime.set(Calendar.SECOND, 0);
		beforeTime.set(Calendar.MILLISECOND, 0);
		Date beforeD = beforeTime.getTime();
		return beforeD;
	}

}
