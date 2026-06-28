package com.example.spring_security.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    @GetMapping("/")
    public String home() {
        return "Welcome to Secure Docs!";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "Login Successful! Welcome to Dashboard.";
    }
}
