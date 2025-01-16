package com.example.GrillTogether.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Disabling security for all endpoints
        http
                .csrf(AbstractHttpConfigurer::disable) // Disable CSRF for testing only
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Allow access to all endpoints
                );
        return http.build();
    }
}
