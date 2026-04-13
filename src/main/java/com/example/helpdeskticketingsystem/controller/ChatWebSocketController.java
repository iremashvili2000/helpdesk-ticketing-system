package com.example.helpdeskticketingsystem.controller;

import com.example.helpdeskticketingsystem.entity.ChatMessage;
import com.example.helpdeskticketingsystem.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ChatWebSocketController {
    private final SimpMessagingTemplate messagingTemplate;
    private final ChatService chatService;

    @MessageMapping("/chat.send")
    public void processMessage(@Payload ChatMessage chatMessage, Principal principal) {
        chatMessage.setSender(principal.getName());

        ChatMessage savedMsg = chatService.saveMessage(chatMessage);


        messagingTemplate.convertAndSendToUser(
                chatMessage.getReceiver(),
                "/queue/messages",
                savedMsg
        );
    }
}