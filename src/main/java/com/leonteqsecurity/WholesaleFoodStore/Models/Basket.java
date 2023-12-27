package com.leonteqsecurity.WholesaleFoodStore.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
@Entity
@Table(name = "basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String productId;
    private int productPrice;
    private int numberOfItems;

    public Basket() {
    }

    public Basket(String productId, int productPrice, int numberOfItems) {
        this.productId = productId;
        this.productPrice = productPrice;
        this.numberOfItems = numberOfItems;
    }

}
