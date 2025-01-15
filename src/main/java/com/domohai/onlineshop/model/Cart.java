package com.domohai.onlineshop.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "carts")
public class Cart {
    @Id
    private ObjectId _id;
    private String userId;
    @DocumentReference
    private List<Product> products;
    private int quantity;
    private double totalPrice;
    
    public Cart(String userId, List<Product> products, int quantity, double totalPrice) {
        this.userId = userId;
        this.products = products;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
    
    public Cart(String userId) {
        this.userId = userId;
        this.products = new ArrayList<>();
        this.quantity = 0;
        this.totalPrice = 0;
    }
    
    public void addProduct(Product product) {
        this.products.add(product);
        this.quantity++;
        this.totalPrice += product.getPrice();
    }
    
    @Override
    public String toString() {
        return "Cart{" +
                "_id=" + _id +
                ", userId='" + userId + '\'' +
                ", products=" + products +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
    
    public ObjectId get_id() {
        return _id;
    }
    
    public void set_id(ObjectId _id) {
        this._id = _id;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public List<Product> getProducts() {
        return products;
    }
    
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getTotalPrice() {
        return totalPrice;
    }
    
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
