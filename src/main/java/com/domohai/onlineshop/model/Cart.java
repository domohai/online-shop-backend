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
    private String userEmail;
    @DocumentReference
    private List<Product> products;
    private int quantity;
    private double totalPrice;
    
    public Cart(String userEmail, List<Product> products, int quantity, double totalPrice) {
        this.userEmail = userEmail;
        this.products = products;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
    
    public Cart(String userEmail) {
        this.userEmail = userEmail;
        this.products = new ArrayList<>();
        this.quantity = 0;
        this.totalPrice = 0;
    }
    
    public Cart() {
    }
    
    public void addProduct(Product product) {
        this.products.add(product);
        this.quantity++;
        this.totalPrice += product.getPrice();
    }
    
    @Override
    public String toString() {
        StringBuilder productsString = new StringBuilder("[");
        for (Product product : products) {
            productsString.append(product.toString()).append(", ");
        }
        productsString.append("]");
        return "Cart{" +
                "_id=" + _id +
                ", userEmail='" + userEmail + '\'' +
                ", products=" + productsString +
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
    
    public String getUserEmail() {
        return userEmail;
    }
    
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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
