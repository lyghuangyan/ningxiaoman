package com.tom.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置资源拦截	(暂时取消，使用springboot默认配置)
 * @author tom
 * @since 2018-10-21 17:14:03
 */
//@Configuration
//@EnableWebMvc
public class ResourceConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
			.addResourceHandler("*.png")
			.addResourceLocations("*.jpg");
	}
	
}
