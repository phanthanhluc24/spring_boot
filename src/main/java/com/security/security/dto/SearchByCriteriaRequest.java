package com.security.security.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchByCriteriaRequest {
    private int age;
    private String gender;
    private int sportId;
}
