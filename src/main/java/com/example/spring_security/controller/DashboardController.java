package com.example.spring_security.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DashboardController {
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/documents")
    public String documents() {
        return "documents";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

}
