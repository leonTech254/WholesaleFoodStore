package com.leonteqsecurity.WholesaleFoodStore.Models;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
@Table
public class FoodProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private  String SKU; //stock keeping unit (a unique code for each product)
   private  String description;
   private String category;
    private int price;
}
