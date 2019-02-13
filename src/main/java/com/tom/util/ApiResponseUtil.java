package com.tom.util;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

//import com.alibaba.fastjson.JSONObject;
//import com.godv.model.generator.BusinessStore;

/**
 * ApiResponse工具类
 * @author tom
 * @since 2018-8-28 10:36:35
 */
public class ApiResponseUtil {

	// json字符串转apiresponse
	/*public static <T> ApiResponse parse(String jsonStr, Class<T> clz) {
		if(StringUtils.isNotEmpty(jsonStr)) {
			ApiResponse request = JSONObject.parseObject(jsonStr, ApiResponse.class);
			if(request != null && request.getData() != null) {
				Object data = null;
				if(request.getData() instanceof List) {
					List<T> list = JSONObject.parseArray(
							JSONObject.toJSONString(request.getData()), clz);
					data = list;
				} else {
					T t = JSONObject.parseObject(JSONObject.toJSONString(request.getData()), clz);
					data = t;
				}
				request.setData(data);
				return request;
			}
		}
		return null;
	}*/
	
	// test
	/*public static void main(String[] args) {
		ApiResponse apiResponse = new ApiResponse();
		BusinessStore businessStore=new BusinessStore();
		businessStore.setId(888);
		apiResponse.setData(businessStore);
		String jsonStr = JSONObject.toJSONString(apiResponse);
		System.out.println(jsonStr);
		System.out.println(parse(jsonStr,BusinessStore.class));
	}*/
}
