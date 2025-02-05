package com.domohai.onlineshop.service;

import com.domohai.onlineshop.model.Cart;
import com.domohai.onlineshop.model.Product;
import com.domohai.onlineshop.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public Cart createCart(String userEmail) {
        Cart cart = new Cart(userEmail);
        return cartRepository.insert(cart);
    }
    
    public Cart addToCart(String userEmail, Product product) {
        // Check if product is already in cart
        Cart cart = cartRepository.findByUserEmail(userEmail);
        Query query = new Query(Criteria.where("userEmail").is(userEmail));
        Update update;
        if (cart.getProducts().contains(product)) {
            update = new Update()
                    .inc("totalPrice", product.getPrice())
                    .inc("quantity", 1);
        } else {
            update = new Update()
                    .push("products", product)
                    .inc("totalPrice", product.getPrice())
                    .inc("quantity", 1);
        }
        mongoTemplate.updateFirst(query, update, Cart.class);
        return cartRepository.findByUserEmail(userEmail);
    }
    
    public Cart removeFromCart(String userEmail, Product product) {
        // Check if product is in cart
        Cart cart = cartRepository.findByUserEmail(userEmail);
        if (!cart.getProducts().contains(product)) {
            throw new IllegalArgumentException("Product not found in cart");
        }
        
        Query query = new Query(Criteria.where("userEmail").is(userEmail));
        Update update = new Update()
                .pull("products", product)
                .inc("totalPrice", -product.getPrice())
                .inc("quantity", -1);
        mongoTemplate.updateFirst(query, update, Cart.class);
        return cartRepository.findByUserEmail(userEmail);
    }
    
}
