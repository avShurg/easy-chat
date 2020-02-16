package com.example.easychat.controller;

import com.example.easychat.entity.Chat;
import com.example.easychat.entity.Message;
import com.example.easychat.service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/chat/message")
    ResponseEntity<Message> send(@RequestParam String author, @RequestParam String text) {
        Message ce = chatService.sendMessage(author, text);
        if (ce == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(ce);
        }
    }

    @GetMapping("/chat/{chatId}")
    List<Message> receiveChat(@PathVariable Long chatId) {
        return chatService.receiveChatHistoryById(chatId);
    }

    @GetMapping("/chat")
    List<Message> receiveCurrentChat() {
        return chatService.receiveCurrentChatHistory();
    }

    @GetMapping("/chats")
    List<Chat> receiveAll() {
        return chatService.receiveAllChats();
    }
}
