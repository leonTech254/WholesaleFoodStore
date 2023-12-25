package com.leonteqsecurity.WholesaleFoodStore.Models;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
@Table(name = "foodproduct")
public class FoodProduct {
    @Id
    private int id;
    private  String SKU; //stock keeping unit (a unique code for each product)
   private  String description;
   private String category;
    private int price;

    public FoodProduct() {
    }

    public FoodProduct(int id, String SKU, String description, String category, int price) {
        this.id = id;
        this.SKU = SKU;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public FoodProduct(String SKU, String description, String category, int price) {
        this.SKU = SKU;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public FoodProduct(int id, String description, int price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }
}
