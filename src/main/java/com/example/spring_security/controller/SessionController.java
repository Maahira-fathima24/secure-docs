package com.example.spring_security.controller;


import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionController {

    @GetMapping("/session/login")
    public String login() {
        return "login-options";
    }

    @GetMapping("/session/demo")
    public String demo() {
        return "session-demo";
    }
}

