package com.example.spring_security.dto;

public class UserInfo {
    private String username;
    private String role;
    private String authentication;

    public UserInfo(String username, String role, String authentication) {
        this.username = username;
        this.role = role;
        this.authentication = authentication;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public String getAuthentication() {
        return authentication;
    }
}
