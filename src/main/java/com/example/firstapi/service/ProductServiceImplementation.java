package com.example.firstapi.service;

import com.example.firstapi.Config.RestTemplateConfig;
import com.example.firstapi.entity.Category;
import com.example.firstapi.entity.FakeStoreResponse;
import com.example.firstapi.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private List<Product> convertListFakeResponseToListProduct(FakeStoreResponse[] fakeStoreResponseArray) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < fakeStoreResponseArray.length; i++) {
            Product product = new Product();
            product.setId(fakeStoreResponseArray[i].getId());
            product.setDescription(fakeStoreResponseArray[i].getDescription());
            product.setImage(fakeStoreResponseArray[i].getImage());
            product.setPrice(fakeStoreResponseArray[i].getPrice());
            product.setTitle(fakeStoreResponseArray[i].getTitle());
            Category category = new Category();
            Random random = new Random();
            category.setId(Math.abs(random.nextLong()));
            category.setName(fakeStoreResponseArray[i].getCategory());
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
