package com.domohai.onlineshop.repository;

import com.domohai.onlineshop.model.Cart;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<Cart, ObjectId> {
    Cart findByUserEmail(String email);
}
