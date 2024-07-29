package com.studyhub.model;

public class AuthenticationResponse {
    private final String jwt;
    private final String role;
    private final String fullName;

    public AuthenticationResponse(String jwt, String role, String fullName) {
        this.jwt = jwt;
        this.role = role;
        this.fullName = fullName;
    }

    public String getJwt() {
        return jwt;
    }

    public String getRole() {
        return role;
    }

    public String getFullName() {
        return fullName;
    }
}
