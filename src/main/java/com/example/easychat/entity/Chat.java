package com.example.easychat.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Chat {
    @Id
    @GeneratedValue
    private Long id;

    public Chat() {
    }

    public Long getId() {
        return id;
    }
}
