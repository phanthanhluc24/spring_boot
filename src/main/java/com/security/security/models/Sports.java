package com.security.security.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Sports")
public class Sports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}
