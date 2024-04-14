package com.security.security.models;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "partners")
public class Partners {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;
    private Integer age;
    private String gender;
    @JoinColumn(name = "sport_id")
    private Integer sportId;

}
