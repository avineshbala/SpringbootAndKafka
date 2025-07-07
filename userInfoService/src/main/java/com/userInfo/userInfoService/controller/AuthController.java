package com.userInfo.userInfoService.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userInfo.userInfoService.dto.AuthRequest;
import com.userInfo.userInfoService.dto.AuthResponse;
import com.userInfo.userInfoService.entity.Role;
import com.userInfo.userInfoService.entity.User;
import com.userInfo.userInfoService.repository.RoleRepository;
import com.userInfo.userInfoService.repository.UserRepository;
import com.userInfo.userInfoService.security.JwtService;
import com.userInfo.userInfoService.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired private AuthenticationManager authManager;
    @Autowired private JwtService jwtService;
    @Autowired private UserService userService;
    @Autowired private RoleRepository roleRepository;
    @Autowired private UserRepository userRepo;

    @PostMapping("/register")
     public ResponseEntity<String> register(@RequestBody AuthRequest request) {
         
        if (userRepo.existsByUsername(request.getUsername())) {
            return ResponseEntity.badRequest().body("Username already taken!");
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));

        Role roleUser = roleRepository.findByName(Role.RoleName.ROLE_USER)
                          .orElseThrow(() -> new RuntimeException("Default role not found"));
        
        user.setRoles(Set.of(roleUser));

        userRepo.save(user);
        return ResponseEntity.ok("User registered");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        authManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        UserDetails userDetails = userService.loadUserByUsername(request.getUsername());
        String token = jwtService.generateToken(userDetails);
        return ResponseEntity.ok(new AuthResponse(token));
    }

}
