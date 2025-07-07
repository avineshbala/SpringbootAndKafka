package com.example.UserTest.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


@Configuration
@ConfigurationProperties(prefix = "server")
public class ServerConfig {

    @Min(1025)
    @Max(65535)
    private int port;

     @NotBlank(message = "Context path cannot be blank!")
    private String contextPath;

    @Value("${server.connectionTimeout:5000}")
    private int connectionTimeout;

    
}
