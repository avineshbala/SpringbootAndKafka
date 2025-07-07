package com.userInfo.userInfoService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userInfo.userInfoService.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Role.RoleName name);
}


