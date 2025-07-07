package com.example.UserTest.Service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("local")
@Component
public class localCache implements Cache {

    @Override
    public String getFromCache() {
     
        return "Value from Local Cache";
    }
    
}
