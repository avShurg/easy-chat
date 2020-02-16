package com.example.easychat.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Message {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String author;
    @NotNull
    private String message;
    private LocalDateTime messageTime;
    @ManyToOne
    @JoinColumn(name = "chatId")
    private Chat chatHistory;

    public Message() {
    }

    public Message(String author, String message, LocalDateTime messageTime, Chat chatHistory) {
        this.author = author;
        this.message = message;
        this.messageTime = messageTime;
        this.chatHistory = chatHistory;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(LocalDateTime messageTime) {
        this.messageTime = messageTime;
    }

    public Chat getChatHistory() {
        return chatHistory;
    }

    public void setChatHistory(Chat chatHistory) {
        this.chatHistory = chatHistory;
    }
}
