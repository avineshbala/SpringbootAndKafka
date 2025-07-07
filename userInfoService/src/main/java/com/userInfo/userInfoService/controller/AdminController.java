package com.userInfo.userInfoService.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.userInfo.userInfoService.entity.User;
import com.userInfo.userInfoService.entity.UserInfo;
import com.userInfo.userInfoService.service.UserInfoService;
import com.userInfo.userInfoService.service.UserService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired UserService userService;
    @Autowired UserInfoService userInfoService;

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Dashboard.";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method=RequestMethod.POST, value="/changePassword", produces = {"application/json"}, consumes = {"application/json"})
      public String changePassword(@RequestBody User user)        {             
            int result = userService.changePassword(user.getUsername(), new BCryptPasswordEncoder().encode(user.getPassword())); 
            if(result > 0)
                return "Password change is Succcessful!";
            else
                return "Password change is failed, Please try again";
        }
    
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method=RequestMethod.GET, value="/getAllUserInfo", produces = {"application/json"})
        public Page<UserInfo> findAllUserInfo() 
        {
            return userInfoService.findAllUserInfo();
        }

}
