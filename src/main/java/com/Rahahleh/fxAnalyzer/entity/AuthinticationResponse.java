package com.Rahahleh.fxAnalyzer.entity;

public class AuthinticationResponse {
    private String jwt;

    public AuthinticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
