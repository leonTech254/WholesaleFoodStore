package com.leonteqsecurity.WholesaleFoodStore.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
