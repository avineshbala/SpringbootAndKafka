package com.example.UserTest.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.example.UserTest.config.DBConfig;

import org.springframework.context.annotation.Bean;

@Configuration
public class Beans {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}
