package com.tom.util;


//import com.jufan.sys.comm.SpringContextUtil;
//import com.jufan.sys.constants.SystemConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

/**
 * Created by DIY on 2017/5/11.
 */
public class HaierCallableUtil implements Callable {

	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
    /*private static final Logger logger = LoggerFactory.getLogger(HaierCallableUtil.class);
    private String applyId;

    public HaierCallableUtil(String applyId) {
        this.applyId = applyId;
    }

    @Override
    public Object call() {
        HaiercashPayUtil haiercashPayUtil = (HaiercashPayUtil) SpringContextUtil.getBean("haiercashPayUtil");
        try {
            haiercashPayUtil.saveLog(applyId, "开始发送海尔", SystemConstant.asset_route_status_10, SystemConstant.asset_route_status_10, SystemConstant.AssetRouteSeq_4);
            haiercashPayUtil.applyHaiercashPay(applyId);
        } catch (Exception e) {
            try {
                haiercashPayUtil.saveLog(applyId, "开始发送海尔-失败", SystemConstant.asset_route_status_10, SystemConstant.asset_route_status_10, SystemConstant.AssetRouteSeq_4);
            } catch (Exception e1) {
                logger.error("HaierStatusCallableUtil applyId:{},e:", applyId, e1);
            }
        }

        return "success";
    }*/
}
