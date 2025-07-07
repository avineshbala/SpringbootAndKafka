package com.example.UserTest.Bean;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
public class CORSSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpRequest) throws Exception{
         System.out.println("Custom Security");
        return httpRequest
            .csrf(csrf->csrf.disable())
            .cors(cors->cors.configurationSource(corsConfigurationSource()))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/user/getCountries").permitAll()
                .requestMatchers("/user/getUserDetails").permitAll()
                .requestMatchers("/user/getUserName").permitAll()
                .requestMatchers("/user/getCountries").permitAll()
                .requestMatchers("/user/addUser").permitAll()
                .requestMatchers("/user/deleteUserById").permitAll()
                .requestMatchers("/user/getConfig").permitAll()
                .requestMatchers("/user/getAllEmployees").permitAll()
                .requestMatchers("/user/findByEmployeeName").permitAll()
                .requestMatchers("/user/findBySupervisor").permitAll()
                .requestMatchers("/user/addEmployee").permitAll()
                .requestMatchers("/user/findAllEmployees").permitAll()
                .requestMatchers("/user/addSalary").permitAll()
                .requestMatchers("/user/updateSalary").permitAll()
                .requestMatchers("/user/updateEmployeeSalary").permitAll()                
                .requestMatchers("/actuator/*").permitAll()
                .anyRequest().authenticated())
            .build();
    }
    

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        configuration.setAllowCredentials(false);
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
