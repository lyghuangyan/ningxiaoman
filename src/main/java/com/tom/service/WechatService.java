package com.tom.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tom.configure.WechatConfig;
import com.tom.util.ApiResponse;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.config.WxMaInMemoryConfig;
import me.chanjar.weixin.common.error.WxErrorException;

@Service("wechatService")
public class WechatService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private WechatConfig wechatConfig;
	
	private static WxMaService service = null;
	
	private WxMaService getWxMaService() {
		if(service != null) {
			return service;
		}
		WxMaInMemoryConfig config = new WxMaInMemoryConfig();
	    config.setAppid(wechatConfig.appid);
	    config.setSecret(wechatConfig.appsecret);
	    //config.setToken(a.getToken());
	    //config.setAesKey(a.getAesKey());
	    config.setMsgDataFormat("JSON");
	    config.setExpiresTime(30000L);
	    service = new WxMaServiceImpl();		        
	    service.setWxMaConfig(config);
		return service;
	}
	
	public ApiResponse loginWithCode(String code) {
		ApiResponse apiResponse = new ApiResponse();
		try {
			WxMaJscode2SessionResult result =
					this.getWxMaService().getUserService().getSessionInfo(code);
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("openid", result.getOpenid());
			apiResponse.setCode("200");
			apiResponse.setData(data);
			apiResponse.setMsg("操作成功！");
		} catch (WxErrorException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			
			apiResponse.setCode("500");
			apiResponse.setData(null);
			apiResponse.setMsg("操作失败！");
		}
		return apiResponse;
	}
}
