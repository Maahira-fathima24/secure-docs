package com.example.spring_security.dto;

public class BasicAuthInfo {
    private String username;
    private String role;
    private String authType;

    public BasicAuthInfo(String username, String role, String authType) {
        this.username = username;
        this.role = role;
        this.authType = authType;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public String getAuthType() {
        return authType;
    }
}
