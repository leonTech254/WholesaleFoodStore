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
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling HTTP requests related to the Wholesale Food Store entities.
 */
@Controller
@AllArgsConstructor
public class FoodStoreController {

    private final FoodProductService foodProductService;
    private final CustomerServices customerServices;
    private final UserService userService;

    /**
     * Retrieves all food products and displays them on the index page.
     *
     * @param model The model for the view.
     * @return The name of the view template.
     */
    @GetMapping("/foodproducts")
    public String getAllProducts(Model model) {
        List<FoodProduct> foodProductList = foodProductService.findAllProducts();
        model.addAttribute("foodProducts", foodProductList);
        return "index";
    }
    @GetMapping("/dashboard")
    public String AllFoodProducts(Model model) {
        return "dashboard";
    }

    /**
     * Retrieves all customers and displays them on the customer index page.
     *
     * @param model The model for the view.
     * @return The name of the view template.
     */
    @GetMapping("/customers")
    public String getAllCustomers(Model model) {
        List<Customer> customerList = customerServices.findAllCustomers();
        model.addAttribute("customers", customerList);
        return "customer/indexB";
    }

    /**
     * Displays the form for adding a new customer.
     *
     * @param model The model for the view.
     * @return The name of the view template.
     */
    @GetMapping("/addCustomerForm")
    public String showAddCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/addCustomer";
    }

    /**
     * Handles the submission of the new customer form.
     *
     * @param customer The customer data from the form.
     * @return Redirects to the add customer form.
     */
    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute Customer customer) {
        customerServices.addCustomer(customer);
        return "redirect:/addCustomerForm";
    }

    /**
     * Displays the form for adding a new food product.
     *
     * @param model The model for the view.
     * @return The name of the view template.
     */
    @GetMapping("/addProductForm")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new FoodProduct());
        return "Products/addProduct";
    }

    /**
     * Handles the submission of the new food product form.
     *
     * @param product The food product data from the form.
     * @return Redirects to the add product form.
     */
    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute FoodProduct product) {
        foodProductService.addProduct(product);
        return "redirect:/addProductForm";
    }

    /**
     * Displays the form for adding a new user.
     *
     * @param model The model for the view.
     * @return The name of the view template.
     */
    @GetMapping("/addUserForm")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "users/addUser";
    }

    /**
     * Handles the submission of the new user form.
     *
     * @param user The user data from the form.
     * @return Redirects to the add user form.
     */
    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/addUserForm";
    }

    /**
     * Retrieves all users and displays them on the users page.
     *
     * @param model The model for the view.
     * @return The name of the view template.
     */
    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> userList = userService.findAllUsers();
        model.addAttribute("users", userList);
        return "users/users";
    }

    /**
     * Displays the form for user login.
     *
     * @param model The model for the view.
     * @return The name of the view template.
     */
    @GetMapping("/user/login")
    public String userLogin(Model model) {
        model.addAttribute("user", new User());
        return "users/userLogin";
    }

    /**
     * Handles the submission of the user login form.
     *
     * @param user The user data from the form.
     * @return Redirects to the user login form.
     */
    @PostMapping("/userCheck")
    public String userProcess(@ModelAttribute User user) {
        userService.loginUser(user);
        return "redirect:/user/login";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int userId) {
        // Call the service to delete the user with the specified ID
        userService.deleteUser(userId);
        // Redirect to the user list page after deletion
        return "redirect:/users";
    }

    @GetMapping("/deleteFoodProduct/{id}")
    public String deleteFoodProduct(@PathVariable("id") int foodProductId) {
        // Call the service to delete the food product with the specified ID
        foodProductService.deleteProduct(foodProductId);
        // Redirect to the food product list page after deletion
        return "redirect:/foodproducts";
    }
}
