package com.userInfo.userInfoService.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.userInfo.userInfoService.entity.UserInfo;

    public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    public List<UserInfo> findByUsername(String username);
    Boolean existsByUsername(String username);

}
