package com.example.spring_security.controller;

import com.example.spring_security.dto.UserInfo;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {


    @GetMapping("/api/user")
    public UserInfo user(Authentication authentication) {

        String role = authentication
                .getAuthorities()
                .iterator()
                .next()
                .getAuthority();

        return new UserInfo(

                authentication.getName(),

                role,

                authentication.getClass().getSimpleName()

        );
    }

}
