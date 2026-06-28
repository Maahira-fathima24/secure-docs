package com.example.spring_security.controller;

import com.example.spring_security.dto.CookieInfoResponse;
import com.example.spring_security.dto.SessionInfoResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionAuthController {

    @GetMapping("/api/session-info")
    public SessionInfoResponse sessionInfo(
            Authentication authentication,
            HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        if (authentication == null || session == null) {
            throw new RuntimeException("No active session found!");
        }

        return new SessionInfoResponse(

                authentication.getName(),

                authentication.getAuthorities()
                        .iterator()
                        .next()
                        .getAuthority(),

                session.getId(),

                session.getCreationTime(),

                session.getLastAccessedTime(),

                session.getMaxInactiveInterval()

        );
    }

    @GetMapping("/api/cookie")
    public CookieInfoResponse cookie(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {

                if ("JSESSIONID".equals(cookie.getName())) {

                    return new CookieInfoResponse(
                            cookie.getName(),
                            cookie.getValue()
                    );

                }
            }
        }

        return new CookieInfoResponse(
                "Not Found",
                "No JSESSIONID Cookie"
        );
    }
}
