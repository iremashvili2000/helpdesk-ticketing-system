package com.example.helpdeskticketingsystem.entity.model;

import com.example.helpdeskticketingsystem.entity.enums.Priority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequest {
    private String title;
    private String description;
    private Priority priority;

}
