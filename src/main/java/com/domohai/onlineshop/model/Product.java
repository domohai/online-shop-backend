package com.domohai.onlineshop.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
    @Id
    private ObjectId _id;
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private String category;
    
    public Product(String name, String description, double price, String imageUrl, String category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.category = category;
    }
    
    public Product() {
        this._id = null;
        this.name = null;
        this.description = null;
        this.price = 0.0;
        this.imageUrl = null;
        this.category = null;
    }
    
    @Override
    public boolean equals(Object object) {
        Product product = (Product) object;
        return this._id.equals(product.get_id());
    }
    
    @Override
    public String toString() {
        return "Product{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
    
    public ObjectId get_id() {
        return _id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public double getPrice() {
        return price;
    }
    
    public String getImageUrl() {
        return imageUrl;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void set_id(ObjectId _id) {
        this._id = _id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
}
