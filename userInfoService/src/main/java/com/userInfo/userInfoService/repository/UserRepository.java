package com.userInfo.userInfoService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.userInfo.userInfoService.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    
    @Modifying
    @Query(value="update User u set u.password=:password where u.username=:username")
    public int changePassword(String username, String password);
    
}

