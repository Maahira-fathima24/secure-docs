package com.example.spring_security.dto;

public class BasicDemoResponse {

    private String username;
    private String authenticationType;
    private String authorizationHeader;
    private String decodedCredentials;

    public BasicDemoResponse() {
    }

    public BasicDemoResponse(String username,
                             String authenticationType,
                             String authorizationHeader,
                             String decodedCredentials) {

        this.username = username;
        this.authenticationType = authenticationType;
        this.authorizationHeader = authorizationHeader;
        this.decodedCredentials = decodedCredentials;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthenticationType() {
        return authenticationType;
    }

    public void setAuthenticationType(String authenticationType) {
        this.authenticationType = authenticationType;
    }

    public String getAuthorizationHeader() {
        return authorizationHeader;
    }

    public void setAuthorizationHeader(String authorizationHeader) {
        this.authorizationHeader = authorizationHeader;
    }

    public String getDecodedCredentials() {
        return decodedCredentials;
    }

    public void setDecodedCredentials(String decodedCredentials) {
        this.decodedCredentials = decodedCredentials;
    }
}
