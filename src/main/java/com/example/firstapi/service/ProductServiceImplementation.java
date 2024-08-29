package com.example.firstapi.service;

import com.example.firstapi.config.RestTemplateConfig;
import com.example.firstapi.entity.Category;
import com.example.firstapi.entity.FakeStoreResponse;
import com.example.firstapi.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductServiceImplementation implements ProductService {

    private final RestTemplateConfig restTemplateConfig;

    @Autowired
    public ProductServiceImplementation(RestTemplateConfig restTemplateConfig) {
        this.restTemplateConfig = restTemplateConfig;
    }

    @Override
    public Product getSingleProduct(long id) {
        FakeStoreResponse fakeStoreResponse = restTemplateConfig.getRestTemplate().getForObject("https://fakestoreapi.com/products/" + id, FakeStoreResponse.class);
        assert fakeStoreResponse != null;
        return convertFakeStoreResponseToDTO(fakeStoreResponse);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreResponse[] fakeStoreResponseArray = restTemplateConfig.getRestTemplate().getForObject("https://fakestoreapi.com/products", FakeStoreResponse[].class);
        assert fakeStoreResponseArray != null;
        return convertListFakeResponseToListProduct(fakeStoreResponseArray);
    }

    @Override
    public Product addProduct(String title, BigDecimal price, String categoryName, String image, String description) {
        return null;
    }

    private List<Product> convertListFakeResponseToListProduct(FakeStoreResponse[] fakeStoreResponseArray) {
        List<Product> products = new ArrayList<>();
        for (FakeStoreResponse fakeStoreResponse : fakeStoreResponseArray) {
            Product product = new Product();
            product.setId(fakeStoreResponse.getId());
            product.setDescription(fakeStoreResponse.getDescription());
            product.setImage(fakeStoreResponse.getImage());
            product.setPrice(fakeStoreResponse.getPrice());
            product.setTitle(fakeStoreResponse.getTitle());
            Category category = new Category();
            Random random = new Random();
            category.setId(Math.abs(random.nextLong()));
            category.setName(fakeStoreResponse.getCategory());
            product.setCategory(category);
            products.add(product);
        }
        return products;
    }

    private Product convertFakeStoreResponseToDTO(FakeStoreResponse fakeStoreResponse) {
        Product product = new Product();
        product.setId(fakeStoreResponse.getId());
        product.setDescription(fakeStoreResponse.getDescription());
        product.setImage(fakeStoreResponse.getImage());
        product.setPrice(fakeStoreResponse.getPrice());
        product.setTitle(fakeStoreResponse.getTitle());
        Category category = new Category();
        Random random = new Random();
        category.setId(Math.abs(random.nextLong()));
        category.setName(fakeStoreResponse.getCategory());
        product.setCategory(category);
        return product;
    }
}
