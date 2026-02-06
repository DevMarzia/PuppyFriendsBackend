package com.devmarzia.PuppyFriendBackend.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${app.jwt-secret}")
    private String jwtSecret;

    @Value("${app.jwt-expiration-milliseconds}")
    private long jwtExpirationDate;

    // Metodo per generare il token JWT
    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(key())
                .compact();
    }

    // ottengo la chiave crittografica decodificata
    private Key key() {
        //stringa Base64
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(encodeSecret(jwtSecret)));
    }

    // MI assicuro che la chiave sia nel formato corretto se non lo è già
    private String encodeSecret(String secret) {
        return java.util.Base64.getEncoder().encodeToString(secret.getBytes());
    }

    // Metodo per estrarre l'username (email) dal token
    public String getUsername(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    // Metodo per validare il token
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException ex) {
            System.err.println("Token JWT non valido");
        } catch (ExpiredJwtException ex) {
            System.err.println("Token JWT scaduto");
        } catch (UnsupportedJwtException ex) {
            System.err.println("Token JWT non supportato");
        } catch (IllegalArgumentException ex) {
            System.err.println("La stringa dei claims JWT è vuota");
        }
        return false;
    }
}