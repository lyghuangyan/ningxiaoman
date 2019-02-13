package com.tom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tom.configure.WechatConfig;

/**
 * hello
 * @author tom
 * @since 2018-11-30 16:33:00
 */
@RestController
@RequestMapping("/security")
public class HelloController {
	@Autowired
	private WechatConfig wechatConfig;
	
	@RequestMapping("")
	public String index() {
		return "hello world!";
	}
	
	@RequestMapping("/wechatconfig")
	public String wechatconfig() {
		return "APPID:"+wechatConfig.appid+" APPSECRET:"+wechatConfig.appsecret;
	}
}
