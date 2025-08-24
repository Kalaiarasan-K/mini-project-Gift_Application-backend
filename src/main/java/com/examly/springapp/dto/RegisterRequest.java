package com.examly.springapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getters, setters, toString, equals, hashCode எல்லாம் auto-generate ஆகும்
@AllArgsConstructor // எல்லா fields உடன் constructor
@NoArgsConstructor  // default constructor
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private String role; // "ADMIN", "APPLICANT", "REVIEWER"
}
