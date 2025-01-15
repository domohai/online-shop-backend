package com.domohai.onlineshop.repository;

import com.domohai.onlineshop.model.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, ObjectId> {
    Product findByName(String name);
    Product findByCategory(String category);
}
