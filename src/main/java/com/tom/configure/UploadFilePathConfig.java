package com.tom.configure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 文件存储的绝对路径和文件读取的虚拟路径
 * @author tom
 * @since 2018-10-21 20:59:06
 */
@Configuration
public class UploadFilePathConfig implements WebMvcConfigurer {
	
	@Value("${file.staticAccessPath}")
    private String staticAccessPath;
    @Value("${file.uploadFolder}")
    private String uploadFolder;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
        	.addResourceHandler(staticAccessPath)
        	.addResourceLocations("file:" + uploadFolder);
    }
}
