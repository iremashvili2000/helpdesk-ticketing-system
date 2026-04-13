package com.example.helpdeskticketingsystem.entity.model;

import com.example.helpdeskticketingsystem.entity.enums.Priority;
import com.example.helpdeskticketingsystem.entity.enums.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponse {
    private Long id;
    private String title;
    private String description;
    private TicketStatus status;
    private Priority priority;
    private String creatorName;
    private String agentName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
