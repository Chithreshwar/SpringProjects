package com.example.firstapi.entity;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class FakeStoreResponse {
    private long id;
    private String title;
    private BigDecimal price;

    private String category;
    private String description;
    private String image;
}
