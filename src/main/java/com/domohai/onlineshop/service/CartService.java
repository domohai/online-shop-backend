package com.domohai.onlineshop.service;

import com.domohai.onlineshop.model.Cart;
import com.domohai.onlineshop.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    
    public Cart createCart(String userId) {
        Cart cart = new Cart(userId);
        return cartRepository.insert(cart);
    }
}
