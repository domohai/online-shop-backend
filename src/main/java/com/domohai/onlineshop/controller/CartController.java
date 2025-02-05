package com.domohai.onlineshop.controller;

import com.domohai.onlineshop.model.Cart;
import com.domohai.onlineshop.model.Product;
import com.domohai.onlineshop.service.CartService;
import com.domohai.onlineshop.service.ProductService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    
    @PutMapping("/add/{productId}")
    public ResponseEntity<Cart> addToCart(@RequestBody Map<String, String> body, @PathVariable String productId) {
        String userEmail = body.get("userEmail");
        ObjectId _id = new ObjectId(productId);
        Product product = productService.getProductById(_id);
        return new ResponseEntity<>(cartService.addToCart(userEmail, product), HttpStatus.OK);
    }
    
    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<Cart> removeFromCart(@RequestBody Map<String, String> body, @PathVariable String productId) {
        String userEmail = body.get("userEmail");
        ObjectId _id = new ObjectId(productId);
        Product product = productService.getProductById(_id);
        return new ResponseEntity<>(cartService.removeFromCart(userEmail, product), HttpStatus.OK);
    }
}
