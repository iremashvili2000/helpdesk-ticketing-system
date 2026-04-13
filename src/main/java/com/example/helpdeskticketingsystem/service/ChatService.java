package com.example.helpdeskticketingsystem.service;

import com.example.helpdeskticketingsystem.entity.ChatMessage;
import com.example.helpdeskticketingsystem.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatMessageRepository chatRepository;

    public ChatMessage saveMessage(ChatMessage message) {
        message.setTimestamp(LocalDateTime.now());
        return chatRepository.save(message);
    }

    public List<ChatMessage> getHistory(String user1, String user2) {
        return chatRepository.findBySenderAndReceiverOrReceiverAndSenderOrderByTimestampAsc(
                user1, user2, user1, user2);
    }
}
