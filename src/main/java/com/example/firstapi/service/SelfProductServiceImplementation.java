package com.example.firstapi.service;

import com.example.firstapi.entity.Category;
import com.example.firstapi.entity.Product;
import com.example.firstapi.respositories.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service("Mysql")
public class SelfProductServiceImplementation implements ProductService {

    private final ProductRespository productRespository;
    private final CategoryServiceImplementation categoryServiceImplementation;

    @Autowired
    public SelfProductServiceImplementation(ProductRespository productRespository, CategoryServiceImplementation categoryServiceImplementation) {
        this.productRespository = productRespository;
        this.categoryServiceImplementation = categoryServiceImplementation;
    }

    @Override
    public Product getSingleProduct(long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>();
    }

    @Override
    public Product addProduct(String title, BigDecimal price, String categoryName, String image, String description) {
        Category category = categoryServiceImplementation.createCategory(categoryName);
        Product product = new Product();
        product.setImage(image);
        product.setPrice(price);
        product.setTitle(title);
        product.setCategory(category);
        product.setDescription(description);
        return productRespository.save(product);
    }
}
