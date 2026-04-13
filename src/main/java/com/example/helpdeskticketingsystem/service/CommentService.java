package com.example.helpdeskticketingsystem.service;

import com.example.helpdeskticketingsystem.entity.Comment;
import com.example.helpdeskticketingsystem.entity.Ticket;
import com.example.helpdeskticketingsystem.entity.User;
import com.example.helpdeskticketingsystem.entity.model.CommentResponse;
import com.example.helpdeskticketingsystem.repository.CommentRepository;
import com.example.helpdeskticketingsystem.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final TicketRepository ticketRepository;

    public void addComment(Long ticketId, String text, User author) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("თიქეთი ვერ მოიძებნა"));

        Comment comment = Comment.builder()
                .content(text)
                .ticket(ticket)
                .author(author)
                .createdAt(LocalDateTime.now())
                .build();

        commentRepository.save(comment);

        // თიქეთის განახლების თარიღის შეცვლა
        ticket.setUpdatedAt(LocalDateTime.now());
        ticketRepository.save(ticket);
    }

    public List<CommentResponse> getCommentsByTicket(Long ticketId) {
        return commentRepository.findByTicketIdOrderByCreatedAtDesc(ticketId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private CommentResponse mapToResponse(Comment comment) {
        return CommentResponse.builder()
                .id(comment.getId())
                .text(comment.getContent())
                .authorName(comment.getAuthor().getFullName())
                .createdAt(comment.getCreatedAt())
                .build();
    }
}
