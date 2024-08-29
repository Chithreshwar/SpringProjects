package com.example.firstapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductRequestDto {
    private String title;
    private BigDecimal price;
    private String categoryName;
    private String image;
    private String description;
}
