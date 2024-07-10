package com.saurabh.ecommerce.product.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("products/**","/actuator/**").permitAll() // Allow access to /users/signup
                        .anyRequest().authenticated() // Secure all other endpoints
                )
                .csrf(csrf -> csrf.disable()) // Disable CSRF
                .cors(cors -> cors.disable()) // Disable CORS
                .formLogin(withDefaults()) // Enable form login with default settings
                .httpBasic(withDefaults()); // Enable HTTP Basic authentication with default settings

        return http.build();
    }
}
