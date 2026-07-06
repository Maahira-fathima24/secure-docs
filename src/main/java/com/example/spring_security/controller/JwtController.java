package com.example.spring_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JwtController {

    @GetMapping("/jwt/page")
    public String loginPage() {
        return "jwt-login";
    }

    @GetMapping("/jwt/demo")
    public String demo() {
        return "jwt-demo";
    }
}
