package com.example.spring_security.controller;

import com.example.spring_security.dto.BasicAuthInfo;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicAuthRestController {
    @GetMapping("api/basic/info")
    public BasicAuthInfo info(Authentication authentication) {

        String role = authentication.getAuthorities()
                .iterator()
                .next()
                .getAuthority();

        return new BasicAuthInfo(
                authentication.getName(),
                role,
                "HTTP Basic"
        );
    }
}
