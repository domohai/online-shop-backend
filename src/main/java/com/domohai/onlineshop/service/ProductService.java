package com.domohai.onlineshop.service;

import com.domohai.onlineshop.model.Product;
import com.domohai.onlineshop.repository.ProductRepository;
import org.bson.types.ObjectId;
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
    
    public Product getProductById(ObjectId id) {
        return productRepository.findById(id).orElse(null);
    }
    
    public Product addProduct(Product product) {
        return productRepository.insert(product);
    }
}
