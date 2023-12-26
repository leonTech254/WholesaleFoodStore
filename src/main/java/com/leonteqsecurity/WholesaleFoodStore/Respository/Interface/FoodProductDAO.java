package com.leonteqsecurity.WholesaleFoodStore.Respository.Interface;

import com.leonteqsecurity.WholesaleFoodStore.Models.FoodProduct;

import java.util.List;

/**
 * Data Access Object (DAO) interface for interacting with food product data in the Wholesale Food Store application.
 */
public interface FoodProductDAO {

    /**
     * Retrieves a list of all food products.
     *
     * @return A list containing all food products.
     */
    List<FoodProduct> findAllProducts();

    /**
     * Finds a food product by its unique identifier.
     *
     * @param productId The unique identifier of the food product to find.
     * @return The food product with the specified identifier, or null if not found.
     */
    FoodProduct findProduct(int productId);

    /**
     * Deletes a food product by its unique identifier.
     *
     * @param productId The unique identifier of the food product to delete.
     * @return true if the food product was successfully deleted, false otherwise.
     */
    boolean deleteProduct(int productId);

    /**
     * Updates the information of an existing food product.
     *
     * @param product The food product object containing updated information.
     * @return true if the food product was successfully updated, false otherwise.
     */
    boolean updateProduct(FoodProduct product);

    /**
     * Adds a new food product to the data store.
     *
     * @param foodProduct The food product object to add.
     * @return true if the food product was successfully added, false otherwise.
     */
    boolean addProduct(FoodProduct foodProduct);
}
