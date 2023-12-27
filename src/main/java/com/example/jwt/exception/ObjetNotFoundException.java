package com.example.jwt.exception;

public class ObjetNotFoundException extends RuntimeException{

    public ObjetNotFoundException() {
    }

    public ObjetNotFoundException(String message) {
        super(message);
    }

    public ObjetNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
