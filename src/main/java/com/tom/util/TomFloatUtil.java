package com.tom.util;

import java.text.DecimalFormat;

/**
 * 自定义Float工具类
 * @author Administrator
 *
 */
public class TomFloatUtil {
	
	/**
	 * 两个整数相除返回保留两位小数点的Float
	 * @param allstars
	 * @param commentcount
	 * @return
	 */
	public static Float division(Integer allstars, Integer commentcount) {
		DecimalFormat df = new DecimalFormat("0.00");
		String value = df.format((float)allstars/commentcount);
		Float result = Float.valueOf(value);
		return result;
	}
	
}
