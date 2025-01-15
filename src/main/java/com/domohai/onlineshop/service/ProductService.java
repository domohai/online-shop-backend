package com.domohai.onlineshop.service;

import com.domohai.onlineshop.model.Product;
import com.domohai.onlineshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public Product addProduct(String name, String description, double price, String imageUrl, String category) {
        Product product = new Product(name, description, price, imageUrl, category);
        return productRepository.insert(product);
    }
    
    public Product addProduct(Product product) {
        return productRepository.insert(product);
    }
}
