package com.devmarzia.PuppyFriendBackend.payload;

//Risposta se il login va a buon fine

import lombok.Data;

@Data
public class JWTAuthResponse {
    private String accessToken;
    private String tokenType = "Bearer";

    public JWTAuthResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}