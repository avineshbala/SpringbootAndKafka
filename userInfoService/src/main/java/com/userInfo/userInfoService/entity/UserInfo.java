package com.userInfo.userInfoService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table (name = "userinfo")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;
    
    @Column(name="username")
    private String username;
    
    @Column(name="fullname")
    private String fullname;
    
    @Column(name="pannumber")
    private String pannumber;

    @Column(name="aadharnumber")
    private Long aadharnumber;

    @Column(name="gender")
    private String gender;

}
