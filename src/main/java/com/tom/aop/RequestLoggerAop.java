package com.tom.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

/**
 * 记录请求日志
 * @author tom
 * @since 2018-10-29 14:48:47
 */
//@Slf4j
//@Aspect
//@Component
public class RequestLoggerAop {
	private final static Logger logger = LoggerFactory.getLogger(RequestLoggerAop.class);
	
	//@Autowired
	//private RequestLogMapper requestLogMapper;
	/*
	@Pointcut("execution(public * com.jinge.controller.*.*(..))")
	public void webLog() {
		
	}
	
	@Around("webLog()")
	public Object arround(ProceedingJoinPoint pjp) {
		try {
			RequestLogWithBLOBs record = new RequestLogWithBLOBs();
			//请求发起时间
			record.setRequestTime(System.currentTimeMillis());
			//record.setClientIp(pjp.);
			Signature signature = pjp.getSignature();
			MethodSignature methodSignature = null;
			ServletRequestAttributes attributes = null;
			RequestAttributes requestAttributes =
					RequestContextHolder.getRequestAttributes();
			if(signature instanceof MethodSignature 
					&& requestAttributes instanceof ServletRequestAttributes) {
				methodSignature = (MethodSignature)signature;
				// 接收到请求，记录请求内容
		        attributes = 
		        		(ServletRequestAttributes) 
		        		RequestContextHolder.getRequestAttributes();
		        HttpServletRequest request = attributes.getRequest();
		        record.setUri(request.getRequestURL().toString());
		        record.setMethod(request.getMethod());
		        record.setClientIp(request.getRemoteAddr());
		        record.setParamData(Arrays.toString(pjp.getArgs()));
		        record.setType(methodSignature.getDeclaringTypeName());
		        record.setSessionId(request.getSession().getId());
		        requestLogMapper.insertSelective(record);
			}
			//请求执行
			Object o = pjp.proceed();
			//请求完成时间
			record.setBackTime(System.currentTimeMillis());
			//请求耗时
			long consumTimeL = record.getBackTime()-record.getRequestTime();
			record.setConsumTime((int)consumTimeL);
			if(signature instanceof MethodSignature
					&& requestAttributes instanceof ServletRequestAttributes) {
				record.setBackData(o.toString());
				record.setHttpStatus(attributes.getResponse().getStatus()+"");
				requestLogMapper.updateByPrimaryKey(record);
				//requestLogMapper.insertSelective(record);
			}
			
			return o;
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
		
	}
	*/
}
