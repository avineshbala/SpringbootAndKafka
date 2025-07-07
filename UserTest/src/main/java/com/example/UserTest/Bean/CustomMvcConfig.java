package com.example.UserTest.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry IR){
        System.out.println("Adding Interceptor Registry");
        IR.addInterceptor(new CustomInterceptor());
    }
    
}
