package com.example.helpdeskticketingsystem.entity.model;

import com.example.helpdeskticketingsystem.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String username;
    private String email;
    private String password;
    private String fullName;
    private Role role; // ROLE_USER ან ROLE_AGENT
}
