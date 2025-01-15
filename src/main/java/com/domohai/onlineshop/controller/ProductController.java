package com.domohai.onlineshop.controller;

import com.domohai.onlineshop.model.Product;
import com.domohai.onlineshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    
    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
    
    @PostMapping("")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
//        String name = body.get("name");
//        String description = body.get("description");
//        double price = Double.parseDouble(body.get("price"));
//        String imageUrl = body.get("imageUrl");
//        String category = body.get("category");
//        return new ResponseEntity<>(productService.addProduct(name, description, price, imageUrl, category), HttpStatus.OK);
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.OK);
    }
}
