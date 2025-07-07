package com.userInfo.userInfoService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.userInfo.userInfoService.entity.UserInfo;
import com.userInfo.userInfoService.repository.UserInfoRepository;

@Service
public class UserInfoService {

    @Autowired UserInfoRepository userInfoRepo;
    public Page<UserInfo> findAllUserInfo(){
        Pageable page = PageRequest.of(0,10,Sort.by("username"));
        return userInfoRepo.findAll(page);
    }
}
