package com.devmarzia.PuppyFriendBackend.payload;
//Cosa invia l'utente per loggarsi

import lombok.Data;

@Data
public class LoginDto {
    private String email;
    private String password;
}