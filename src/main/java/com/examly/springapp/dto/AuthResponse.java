package com.examly.springapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private Long id;     // ✅ add user id
    private String token;
    private String email;
    private String role;
    
}
