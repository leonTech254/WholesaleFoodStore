package com.leonteqsecurity.WholesaleFoodStore.Service;

import com.leonteqsecurity.WholesaleFoodStore.Models.FoodProduct;
import com.leonteqsecurity.WholesaleFoodStore.Respository.Interface.FoodProductDAO;
import com.leonteqsecurity.WholesaleFoodStore.Respository.Interface.FoodProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class FoodProductService implements FoodProductDAO {
    private final FoodProductRepository foodProductRespository;
    @Override
    public List<FoodProduct> findAllProducts() {
        return foodProductRespository.findAllProducts();
    }

    @Override
    public FoodProduct findProduct(int productId) {
        return  foodProductRespository.findProduct(productId);
    }

    @Override
    public boolean deleteProduct(int productID) {
       return foodProductRespository.deleteProduct(productID);

    }

    @Override
    public boolean updateProduct(FoodProduct product) {
        return foodProductRespository.updateProduct(product.getDescription(),product.getPrice(),product.getId());
    }

    @Override
    public boolean addProduct(FoodProduct foodProduct) {

        foodProductRespository.addProduct(foodProduct.getSKU(),foodProduct.getDescription(),foodProduct.getCategory(),foodProduct.getPrice());
        return  false;
    }
}
