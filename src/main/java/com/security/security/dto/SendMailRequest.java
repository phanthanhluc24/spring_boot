package com.security.security.dto;

import lombok.Data;

@Data
public class SendMailRequest {
    private String to;
    private String subject;
    private String content; 
}
