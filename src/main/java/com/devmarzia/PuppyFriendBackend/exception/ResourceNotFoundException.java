package com.devmarzia.PuppyFriendBackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s non trovato con %s : '%s'", resourceName, fieldName, fieldValue));
    }

    // Costruttore alternativo per messaggi semplici
    public ResourceNotFoundException(String message) {
        super(message);
    }
}