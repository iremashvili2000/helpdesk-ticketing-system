package com.example.helpdeskticketingsystem.controller;

import com.example.helpdeskticketingsystem.entity.User;
import com.example.helpdeskticketingsystem.entity.enums.Priority;
import com.example.helpdeskticketingsystem.entity.enums.TicketStatus;
import com.example.helpdeskticketingsystem.entity.model.TicketRequest;
import com.example.helpdeskticketingsystem.entity.model.TicketResponse;
import com.example.helpdeskticketingsystem.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @GetMapping("/search")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_AGENT')")
    public ResponseEntity<List<TicketResponse>> searchTickets(
            @RequestParam(required = false) TicketStatus status,
            @RequestParam(required = false) Priority priority,
            @RequestParam(required = false) String title
    ) {
        return ResponseEntity.ok(ticketService.searchTickets(status, priority, title));
    }

    @PostMapping
    public ResponseEntity<TicketResponse> createTicket(
            @RequestBody TicketRequest request,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(ticketService.createTicket(request, user));
    }

    @GetMapping
    public ResponseEntity<List<TicketResponse>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    @PutMapping("/{id}/assign")
    @PreAuthorize("hasRole('ROLE_AGENT')")
    public ResponseEntity<TicketResponse> assignTicket(
            @PathVariable Long id,
            @AuthenticationPrincipal User agent
    ) {
        return ResponseEntity.ok(ticketService.assignTicket(id, agent));
    }

    @PutMapping("/{id}/close")
    @PreAuthorize("hasRole('ROLE_AGENT')")
    public ResponseEntity<TicketResponse> closeTicket(@PathVariable Long id) {
        return ResponseEntity.ok(ticketService.closeTicket(id));
    }

}
