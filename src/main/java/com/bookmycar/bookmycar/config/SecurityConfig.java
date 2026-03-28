package com.bookmycar.bookmycar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Crucial for Swagger/Postman POST requests
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Permits all APIs as you requested
                );

        return http.build();
    }
}
