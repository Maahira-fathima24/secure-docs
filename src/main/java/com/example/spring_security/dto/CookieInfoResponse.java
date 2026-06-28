package com.example.spring_security.dto;

public class CookieInfoResponse {

    private String cookieName;
    private String cookieValue;

    public CookieInfoResponse(String cookieName, String cookieValue) {
        this.cookieName = cookieName;
        this.cookieValue = cookieValue;
    }

    public String getCookieName() {
        return cookieName;
    }

    public String getCookieValue() {
        return cookieValue;
    }
}
