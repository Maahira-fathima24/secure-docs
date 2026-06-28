package com.example.spring_security.dto;

public class SessionInfoResponse {

    private String username;
    private String role;
    private String sessionId;
    private long creationTime;
    private long lastAccessedTime;
    private int maxInactiveInterval;

    public SessionInfoResponse() {
    }

    public SessionInfoResponse(String username,
                               String role,
                               String sessionId,
                               long creationTime,
                               long lastAccessedTime,
                               int maxInactiveInterval) {

        this.username = username;
        this.role = role;
        this.sessionId = sessionId;
        this.creationTime = creationTime;
        this.lastAccessedTime = lastAccessedTime;
        this.maxInactiveInterval = maxInactiveInterval;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public String getSessionId() {
        return sessionId;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public long getLastAccessedTime() {
        return lastAccessedTime;
    }

    public int getMaxInactiveInterval() {
        return maxInactiveInterval;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

    public void setLastAccessedTime(long lastAccessedTime) {
        this.lastAccessedTime = lastAccessedTime;
    }

    public void setMaxInactiveInterval(int maxInactiveInterval) {
        this.maxInactiveInterval = maxInactiveInterval;
    }
}
