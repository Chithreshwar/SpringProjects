package com.example.firstapi.service;

import com.example.firstapi.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    Product getSingleProduct(long id);

    List<Product> getAllProducts();

    Product addProduct(String title, BigDecimal price, String categoryName, String image, String description);
}
