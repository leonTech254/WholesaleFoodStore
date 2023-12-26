package com.leonteqsecurity.WholesaleFoodStore.Service;

import com.leonteqsecurity.WholesaleFoodStore.Models.FoodProduct;
import com.leonteqsecurity.WholesaleFoodStore.Respository.Interface.FoodProductDAO;
import com.leonteqsecurity.WholesaleFoodStore.Respository.Interface.FoodProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Service class for managing FoodProduct entities in the Wholesale Food Store application.
 */
@Service
@AllArgsConstructor
public class FoodProductService implements FoodProductDAO {

    private final FoodProductRepository foodProductRepository;

    /**
     * Retrieves all food products from the repository.
     *
     * @return List of all food products.
     */
    @Override
    public List<FoodProduct> findAllProducts() {
        return foodProductRepository.findAllProducts();
    }

    /**
     * Finds a food product by its ID.
     *
     * @param productId The ID of the food product to find.
     * @return The found food product or null if not found.
     */
    @Override
    public FoodProduct findProduct(int productId) {
        return foodProductRepository.findProduct(productId);
    }

    /**
     * Deletes a food product by its ID.
     *
     * @param productId The ID of the food product to delete.
     * @return True if the food product is deleted, false otherwise.
     */
    @Override
    public boolean deleteProduct(int productId) {
        return foodProductRepository.deleteProduct(productId);
    }

    /**
     * Updates a food product in the repository.
     *
     * @param product The food product with updated information.
     * @return True if the food product is updated, false otherwise.
     */
    @Override
    public boolean updateProduct(FoodProduct product) {
        return foodProductRepository.updateProduct(product.getDescription(), product.getPrice(), product.getId());
    }

    /**
     * Adds a new food product to the repository.
     *
     * @param foodProduct The food product to add.
     * @return True if the food product is added, false otherwise.
     */
    @Override
    public boolean addProduct(FoodProduct foodProduct) {
        String productId = UUID.randomUUID().toString().substring(0, 6).replace("-", "");
        foodProduct.setSKU(productId);
        foodProductRepository.addProduct(foodProduct.getSKU(), foodProduct.getDescription(), foodProduct.getCategory(), foodProduct.getPrice());
        return false;
    }
}
