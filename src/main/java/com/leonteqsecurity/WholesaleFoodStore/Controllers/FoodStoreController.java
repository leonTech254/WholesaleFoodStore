package com.leonteqsecurity.WholesaleFoodStore.Controllers;

import com.leonteqsecurity.WholesaleFoodStore.Models.Customer;
import com.leonteqsecurity.WholesaleFoodStore.Models.FoodProduct;
import com.leonteqsecurity.WholesaleFoodStore.Service.CustomerServices;
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

    private  final CustomerServices customerServices;

    @GetMapping("/foodproducts")
    public String getAllProducts(Model model) {
        List<FoodProduct> foodProductList = foodProductService.findAllProducts();
        model.addAttribute("foodProducts", foodProductList);
        return "index";
    }

    @GetMapping("/customers")
    public String getAllCustomers(Model model) {
        List<Customer> customerList = customerServices.findAllCustomers();
        model.addAttribute("customers", customerList);
        return "customer/index";
    }
}
