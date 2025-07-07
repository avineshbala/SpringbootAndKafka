package com.example.UserTest.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.Getter;

import lombok.Setter;

@Getter
@Setter
@Configuration
//@Profile("uat")
@ConfigurationProperties (prefix = "spring.datasource")
@ConditionalOnProperty (prefix = "spring.datasource", name = "username", havingValue = "postgres")

public class DBConfig {   

    private String url;
    private String username;
    private String password;
}
