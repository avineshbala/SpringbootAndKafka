package com.userInfo.userInfoService.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.userInfo.userInfoService.entity.UserInfo;
import com.userInfo.userInfoService.exception.UserExistsException;
import com.userInfo.userInfoService.repository.UserInfoRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired UserInfoRepository userInfoRepo;
    @GetMapping("/profile")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @RequestMapping(method=RequestMethod.POST, value="/addUserInfo", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<UserInfo> addUserInfo(@RequestBody UserInfo userInfo) throws UserExistsException {
        HttpHeaders headers = new HttpHeaders();
        if (userInfoRepo.existsByUsername(userInfo.getUsername())) {
            throw new UserExistsException("This user name already exists");
        }else{
            UserInfo response = userInfoRepo.save(userInfo);
            headers.set("Status", "User Created Successfully");
            return new ResponseEntity<UserInfo>(response, headers, HttpStatus.OK);
        }
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @RequestMapping(method=RequestMethod.GET, value="/getUserInfo", produces = {"application/json"})
      public List<UserInfo> getUserInfo(@RequestParam (name="username") String username) {
            return userInfoRepo.findByUsername(username);
        }
}
