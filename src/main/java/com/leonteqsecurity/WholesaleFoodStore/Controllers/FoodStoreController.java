package com.leonteqsecurity.WholesaleFoodStore.Controllers;

import com.leonteqsecurity.WholesaleFoodStore.Models.FoodProduct;
import com.leonteqsecurity.WholesaleFoodStore.Service.FoodProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class FoodStoreController {

    private final FoodProductService foodProductService;

    @GetMapping("/foodproducts")
    public String getAllProducts(Model model) {
        List<FoodProduct> foodProductList = foodProductService.findAllProducts();
        model.addAttribute("foodProducts", foodProductList);
        return "index";
    }
}
