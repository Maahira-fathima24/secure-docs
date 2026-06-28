package com.example.spring_security.security;


import com.example.spring_security.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {
    private final CustomUserDetailsService userDetailsService;

    public PasswordConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            HttpSecurity http,
            PasswordEncoder passwordEncoder)
            throws Exception {

        AuthenticationManagerBuilder builder =
                http.getSharedObject(AuthenticationManagerBuilder.class);

        builder
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);

        return builder.build();
    }
}
