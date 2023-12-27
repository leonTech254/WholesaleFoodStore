package com.leonteqsecurity.WholesaleFoodStore.Models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

/**
 * Represents a food product in the Wholesale Food Store application.
 * This class is annotated with {@code @Entity} to indicate that it is a JPA entity,
 * and it is mapped to the "foodproduct" table.
 */
@Builder
@Data
@Entity
@Table(name = "foodproduct")
public class FoodProduct {

    /**
     * The unique identifier for the food product.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * The Stock Keeping Unit (SKU) for the food product. It is a unique code for each product.
     */
    private String SKU;

    /**
     * The description of the food product.
     */
    private String description;

    /**
     * The category of the food product.
     */
    private String category;

    /**
     * The price of the food product.
     */
    private int price;

    /**
     * Default constructor for the FoodProduct class.
     */
    public FoodProduct() {
    }

    /**
     * Constructor for creating a food product with specified ID, SKU, description, category, and price.
     *
     * @param id          The unique identifier for the food product.
     * @param SKU         The Stock Keeping Unit (SKU) for the food product.
     * @param description The description of the food product.
     * @param category    The category of the food product.
     * @param price       The price of the food product.
     */
    public FoodProduct(int id, String SKU, String description, String category, int price) {
        this.id = id;
        this.SKU = SKU;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    /**
     * Constructor for creating a food product with specified SKU, description, category, and price.
     *
     * @param SKU         The Stock Keeping Unit (SKU) for the food product.
     * @param description The description of the food product.
     * @param category    The category of the food product.
     * @param price       The price of the food product.
     */
    public FoodProduct(String SKU, String description, String category, int price) {
        this.SKU = SKU;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    /**
     * Constructor for creating a food product with specified ID, description, and price.
     *
     * @param id          The unique identifier for the food product.
     * @param description The description of the food product.
     * @param price       The price of the food product.
     */
    public FoodProduct(int id, String description, int price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    // Getter and setter methods for each field...
}
