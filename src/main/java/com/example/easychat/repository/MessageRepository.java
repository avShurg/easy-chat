package com.example.easychat.repository;

import com.example.easychat.entity.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {
    @Query(value = "SELECT * FROM CHAT_ELEMENT WHERE CHAT_ID=?1", nativeQuery = true)
    List<Message> findByChatId(Long id);
}
