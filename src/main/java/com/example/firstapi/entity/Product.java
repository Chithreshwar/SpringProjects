package com.example.firstapi.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private long id;
    private String title;
    private BigDecimal price;
    private Category category;
    private String description;
    private String image;
}
