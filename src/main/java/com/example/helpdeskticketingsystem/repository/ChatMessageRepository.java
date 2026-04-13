package com.example.helpdeskticketingsystem.repository;

import com.example.helpdeskticketingsystem.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findBySenderAndReceiverOrReceiverAndSenderOrderByTimestampAsc(
            String s1, String r1, String s2, String r2);

    int deleteByTimestampBefore(LocalDateTime expiryDate);
}
