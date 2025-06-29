package com.example.touragency.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tourName;   // Bu alan ve getter/setter olmalı

    private Double price;
    private Integer duration;
    private String description;

}
