package com.example.UserTest.Bean;

import java.util.UUID;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler) throws Exception{
        System.out.println("CustomInterceptor---> preHandle Method");
        String uid = UUID.randomUUID().toString();
        response.setHeader("Token",uid);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object Handler, @Nullable ModelAndView modelAndView) throws Exception{
        System.out.println("CustomInterceptor---> postHandle Method");
        
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {

                System.out.println("Inside afterCompletion Method----->");
                
            }
}
