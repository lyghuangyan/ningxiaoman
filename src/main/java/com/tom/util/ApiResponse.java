package com.tom.util;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.alibaba.fastjson.JSONObject;

/**
 * 	接口消息类
 * @author tom
 * @since 2018-8-28 10:24:47
 * @param <T>
 */
public class ApiResponse<T> implements Serializable {
	
	/**
	 * @since 2018-8-28 10:24:40
	 */
	private static final long serialVersionUID = 7921415668166548069L;

	private String code="200";
	
	private String msg="操作成功";
	
	private T data=null;
	
	private long timestamp=System.currentTimeMillis();

	public ApiResponse() {
		super();
		this.code = "200";
		this.msg = "操作成功";
		this.timestamp=System.currentTimeMillis();
	}

	public ApiResponse(String code, String msg, T data, long timestamp) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
		this.timestamp = timestamp;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
	public String toJson() {
		return JSONObject.toJSONString(this);
	}
	
}
