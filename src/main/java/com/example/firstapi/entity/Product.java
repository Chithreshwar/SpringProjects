package com.example.firstapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private BigDecimal price;
    @ManyToOne
    private Category category;
    private String description;
    private String image;
}
