package com.example.myretro.exception;

public class RetroBoardNotFoundException extends RuntimeException {

    public RetroBoardNotFoundException() {
        super("RetroBoard Not found");
    }

    public RetroBoardNotFoundException(String message) {
        super(String.format("RetroBoard Not Found: {}", message));
    }

    public RetroBoardNotFoundException(String message, Throwable cause) {
        super(String.format("RetroBoard Not Found: {}", message), cause);
    }
}
