package com.example.spring_security.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/public/hello")
    public String publicHello() {
        return "Public Endpoint";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "Admin Dashboard";
    }

    @GetMapping("/manager/dashboard")
    public String managerDashboard() {
        return "Manager Dashboard";
    }

    @GetMapping("/employee/dashboard")
    public String employeeDashboard() {
        return "Employee Dashboard";
    }

}
