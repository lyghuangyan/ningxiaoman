package com.tom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * springboot启动类
 * @author tom
 * @since 2018-10-20 19:59:57
 */
@SpringBootApplication
@MapperScan({"com.tom.dao","com.tom.dao.generator"})
@EnableAutoConfiguration(exclude = {
org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
public class SpringbootApplication extends SpringBootServletInitializer {
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringbootApplication.class);
    }
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
