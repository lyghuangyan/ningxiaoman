package com.tom.configure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaInMemoryConfig;

@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatConfig {
    public String appid;
	public String appsecret;
	public String expirestime;
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getAppsecret() {
		return appsecret;
	}
	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}
	public String getExpirestime() {
		return expirestime;
	}
	public void setExpirestime(String expirestime) {
		this.expirestime = expirestime;
	}

}
