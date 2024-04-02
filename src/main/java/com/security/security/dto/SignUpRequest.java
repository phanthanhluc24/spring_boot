package com.security.security.dto;

import lombok.Data;

@Data
public class SignUpRequest {
    private String fullname;
    private String email;
    private String password;
    // private Role role;
}
