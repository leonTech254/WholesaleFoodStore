package com.leonteqsecurity.WholesaleFoodStore.Controllers;

import com.leonteqsecurity.WholesaleFoodStore.Models.Customer;
import com.leonteqsecurity.WholesaleFoodStore.Models.FoodProduct;
import com.leonteqsecurity.WholesaleFoodStore.Models.User;
import com.leonteqsecurity.WholesaleFoodStore.Service.CustomerServices;
import com.leonteqsecurity.WholesaleFoodStore.Service.FoodProductService;
import com.leonteqsecurity.WholesaleFoodStore.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class FoodStoreController {

    private final FoodProductService foodProductService;

    private  final CustomerServices customerServices;
    private  final UserService userService;

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

    @GetMapping("/addCustomerForm")
    public String showAddCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/addCustomer";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute Customer customer) {
        customerServices.addCustomer(customer);
        return "redirect:/addCustomerForm";
    }

    @GetMapping("/addProductForm")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new FoodProduct());
        return "Products/addProduct";
    }
    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute FoodProduct product) {
        foodProductService.addProduct(product);
        return "redirect:/addProductForm";
    }

    @GetMapping("/addUserForm")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "users/addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/addUserForm";
    }
    @GetMapping("/users")
    public String getAllUSers(Model model) {
        List<User> userList = userService.findAllUsers();
        model.addAttribute("users", userList);
        return "users/users";
    }
}
