package com.devmarzia.PuppyFriendBackend.payload;

//Cosa invia l'utente per registrarsi

import lombok.Data;

import java.util.Set;

@Data
public class RegisterDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Set<String> roles;
}
