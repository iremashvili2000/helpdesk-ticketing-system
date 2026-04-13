package com.example.helpdeskticketingsystem.controller;

import com.example.helpdeskticketingsystem.entity.ChatMessage;
import com.example.helpdeskticketingsystem.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatHistoryController {
    private final ChatService chatService;

    @GetMapping("/history/{withUser}")
    public ResponseEntity<List<ChatMessage>> getChatHistory(@PathVariable String withUser, Principal principal) {
        return ResponseEntity.ok(chatService.getHistory(principal.getName(), withUser));
    }
}
