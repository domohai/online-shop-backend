package com.domohai.onlineshop.controller;

import com.domohai.onlineshop.model.Cart;
import com.domohai.onlineshop.model.Product;
import com.domohai.onlineshop.service.CartService;
import com.domohai.onlineshop.service.ProductService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    
    @PostMapping("/add")
    public Cart addToCart(@RequestBody Map<String, String> body) {
        String userEmail = body.get("userEmail");
        ObjectId productId = new ObjectId(body.get("productId"));
        Product product = productService.getProductById(productId);
        return cartService.addToCart(userEmail, product);
    }
}
