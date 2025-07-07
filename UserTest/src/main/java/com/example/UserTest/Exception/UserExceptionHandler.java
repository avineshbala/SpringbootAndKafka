package com.example.UserTest.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.UserTest.Bean.Error;

@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(exception = CustomException.class)
     public Error handleCustomException(CustomException e){
        System.out.println("Inside Generic Exception Handler--->");
        return new Error("Custom Exception", e.getMessage());
    }
    
    @ExceptionHandler(exception = Exception.class)
    public Error handleGenericException(Exception e){
        e.printStackTrace();
        return new Error("123", e.getMessage());
    }
}
