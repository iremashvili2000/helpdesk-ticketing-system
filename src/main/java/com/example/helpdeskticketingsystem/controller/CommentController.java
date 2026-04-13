package com.example.helpdeskticketingsystem.controller;

import com.example.helpdeskticketingsystem.entity.User;
import com.example.helpdeskticketingsystem.entity.model.CommentResponse;
import com.example.helpdeskticketingsystem.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets/{ticketId}/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<String> addComment(
            @PathVariable Long ticketId,
            @RequestBody String text,
            @AuthenticationPrincipal User user
    ) {
        commentService.addComment(ticketId, text, user);
        return ResponseEntity.ok("კომენტარი წარმატებით დაემატა");
    }


    @GetMapping
    public ResponseEntity<List<CommentResponse>> getComments(@PathVariable Long ticketId) {
        List<CommentResponse> comments = commentService.getCommentsByTicket(ticketId);
        return ResponseEntity.ok(comments);
    }
}
