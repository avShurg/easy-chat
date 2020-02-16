package com.example.easychat.exception;

public class ChatNotFoundException extends RuntimeException {
    public ChatNotFoundException(Long id) {
        super("Could not found Message with ChatId =  " + id);
    }
}
