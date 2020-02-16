package com.example.easychat.service;

import com.example.easychat.entity.Chat;
import com.example.easychat.entity.Message;
import com.example.easychat.exception.ChatNotFoundException;
import com.example.easychat.repository.ChatRepository;
import com.example.easychat.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatService {
    private final ChatRepository chatRepository;
    private final MessageRepository chatElementRepository;
    private Chat chatHistory;

    public ChatService(ChatRepository chatRepository, MessageRepository chatElementRepository) {
        this.chatRepository = chatRepository;
        this.chatElementRepository = chatElementRepository;
        createNewChat();
    }

    public Message sendMessage(Message chatElement) {
        chatElement.setMessageTime(LocalDateTime.now());
        return chatElementRepository.save(chatElement);
    }

    public Message sendMessage(String author, String text) {
        Message chatElement = new Message(
                author,
                text,
                LocalDateTime.now(),
                chatHistory
        );
        return chatElementRepository.save(chatElement);
    }

    public List<Message> receiveChatHistoryById(Long chatId) {
        List<Message> listMessage = chatElementRepository.findByChatId(chatId);
        if (listMessage.isEmpty()) {
            throw new ChatNotFoundException(chatId);
        }
        return listMessage;
    }

    public List<Message> receiveCurrentChatHistory() {
        return chatElementRepository.findByChatId(chatHistory.getId());
    }

    public List<Chat> receiveAllChats() {
        return chatRepository.findAll();
    }

    private void createNewChat() {
        chatHistory = new Chat();
        chatRepository.save(chatHistory);
    }
}
