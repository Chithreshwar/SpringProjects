package com.example.firstapi.controller;

import com.example.firstapi.dto.ProductRequestDto;
import com.example.firstapi.entity.Product;
import com.example.firstapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(@Qualifier("Mysql") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{id}")
    public Product getSingleProduct(@PathVariable("id") long id) {
        return productService.getSingleProduct(id);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/")
    public Product addProduct(@RequestBody ProductRequestDto productRequestDto) {
        return productService.addProduct(productRequestDto.getTitle(), productRequestDto.getPrice(), productRequestDto.getCategoryName(), productRequestDto.getImage(), productRequestDto.getDescription());
    }
}
