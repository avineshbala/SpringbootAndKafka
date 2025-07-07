package com.example.UserTest.Service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!local")
public class redisCache implements Cache {

    @Override
    public String getFromCache() {
        return "Value from Redis Cache";
    }

    
    
}
