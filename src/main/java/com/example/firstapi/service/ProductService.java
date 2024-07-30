package com.example.firstapi.service;

import com.example.firstapi.entity.Product;

import java.util.List;

public interface ProductService {
    public Product getSingleProduct(long id);

    public List<Product> getAllProducts();
}
