package com.cxy.config;

import com.cxy.controller.interceptor.ProjectInterceptor;
import com.cxy.controller.interceptor.ProjectInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan({"com.cxy.controller"})
//@ComponentScan({"com.cxy.controller","com.cxy.config"})
// com.cxy.config是为了SpringMvcSupport
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {

    @Autowired
    private ProjectInterceptor projectInterceptor;
    @Autowired
    private ProjectInterceptor2 projectInterceptor2;


    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(("/pages/**")).addResourceLocations("/pages/");
        registry.addResourceHandler(("/css/**")).addResourceLocations("/css/");
        registry.addResourceHandler(("/js/**")).addResourceLocations("/js/");
        registry.addResourceHandler(("/plugins/**")).addResourceLocations("/plugins/");
    }


    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(projectInterceptor).addPathPatterns("/books","/books/*");
        registry.addInterceptor(projectInterceptor2).addPathPatterns("/books","/books/*");
    }

}
