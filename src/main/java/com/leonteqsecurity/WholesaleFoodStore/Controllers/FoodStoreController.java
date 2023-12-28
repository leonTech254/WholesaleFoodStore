package com.leonteqsecurity.WholesaleFoodStore.Controllers;

import com.leonteqsecurity.WholesaleFoodStore.Models.*;
import com.leonteqsecurity.WholesaleFoodStore.Respository.Interface.FoodItemService;
import com.leonteqsecurity.WholesaleFoodStore.Service.BasketService;
import com.leonteqsecurity.WholesaleFoodStore.Service.CustomerServices;
import com.leonteqsecurity.WholesaleFoodStore.Service.FoodProductService;
import com.leonteqsecurity.WholesaleFoodStore.Service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller class for handling HTTP requests related to the Wholesale Food Store entities.
 */
@Controller
@AllArgsConstructor
public class FoodStoreController {

    private final FoodProductService foodProductService;
    private final CustomerServices customerServices;
    private final UserService userService;
    private final BasketService basketService;
    private  final FoodItemService foodItemService;

    /**
     * Retrieves all food products and displays them on the index page.
     *
     * @param model The model for the view.
     * @return The name of the view template.
     */
    @GetMapping("/")
    public String indexPage(Model model) {

        return "home";
    }

    @GetMapping("/foodproducts")
    public String getAllProducts(Model model) {
        List<FoodProduct> foodProductList = foodProductService.findAllProducts();
        model.addAttribute("foodProducts", foodProductList);
        List<Basket> basketList=basketService.getAllBaskets();
        model.addAttribute("numBasket",String.valueOf(basketList.size()));
        return "indexB";
    }
    @GetMapping("/dashboard")
    public String AllFoodProducts(Model model,@SessionAttribute("user") User user) {
        model.addAttribute("username",user.getUsername());

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
        return "customer/index";
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
    public String userProcess(Model model, @ModelAttribute User user, HttpSession session) {
        boolean isTrue = userService.loginUser(user);

        if (isTrue) {
            // Assuming your User class has a getUsername method
            String username = user.getUsername();

            // Save the user information in the session
            session.setAttribute("user", user);
            return "redirect:/dashboard";
        } else {
            return "redirect:/user/login";
        }
    }

    @GetMapping("/user/logout")
    public String logout(HttpSession session) {
        // Invalidate (destroy) the session
        session.invalidate();

        // Redirect to the login page or any other desired page
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

    @GetMapping("/foodproducts/filterByName")
    public String filterProductsByName(Model model, @RequestParam String keyword) {
        List<FoodProduct> filteredProducts = foodProductService.filterProductsByName(keyword);
        model.addAttribute("foodProducts", filteredProducts);
        return "Products/FilterProducts";
    }


    /**
     * Retrieves food products based on the description keyword and displays them on the index page.
     *
     * @param model   The model for the view.
     * @param keyword The keyword to filter food products by description.
     * @return The name of the view template.
     */
    @GetMapping("/foodproducts/filterByDescription")
    public String filterByDescription(Model model, @RequestParam String keyword) {
        List<FoodProduct> filteredProducts = foodProductService.findByDescriptionContaining(keyword);
        model.addAttribute("foodProducts", filteredProducts);
        return "indexB";
    }

    /**
     * Retrieves the basket items and displays them on the basket page.
     *
     * @param model The model for the view.
     * @return The name of the view template.
     */
    @GetMapping("/basket")
    public String getBasket(Model model) {
        List<Basket> basketItems = basketService.getAllBaskets();
        model.addAttribute("basketItems", basketItems);
        return "basket";
    }

    /**
     * Adds a product to the basket.
     *
     * @return ResponseEntity with status.
     */
    @GetMapping("/addToBasket")
    public String addToBasket(Model model,@RequestParam("productId") String productId,
                                              @RequestParam("description") String description,
                                              @RequestParam("price") int price ) {
        Basket basket= new Basket();
        basket.setProductId(productId);
        basket.setNumberOfItems(0);
        basket.setProductPrice(price);
        basketService.saveBasket(basket);

        return "redirect:/foodproducts";
    }

    @GetMapping("/get/all/products/expiry")
    public String getAllFoodItems(Model model) {
        List<FoodItem> foodItems = foodItemService.getAllFoodItems();
        List<FoodProduct> foodProductList=foodProductService.findAllProducts();
        model.addAttribute("foodItems", foodItems);
        model.addAttribute("foodProducts", foodProductList);

        return "foodItems/list"; // Assuming you have a "list" Thymeleaf template
    }

    @GetMapping("/{id}")
    public String getFoodItemById(@PathVariable int id, Model model) {
        Optional<FoodItem> foodItem = foodItemService.getFoodItemById(id);
        foodItem.ifPresent(value -> model.addAttribute("foodItem", value));
        return "foodItems/details"; // Assuming you have a "details" Thymeleaf template
    }

    @PostMapping("/addFoodItem")
    public String addFoodItem(@ModelAttribute FoodItem foodItem) {
        // Retrieve FoodProduct based on the selected ID
        FoodProduct selectedFoodProduct = foodProductService.getFoodProductById(foodItem.getFoodProduct().getId());

        // Set the selected FoodProduct in the FoodItem
        foodItem.setFoodProduct(selectedFoodProduct);

        // Save the FoodItem
        foodItemService.saveFoodItem(foodItem);

        return "redirect:/food-items"; // Redirect to the page showing all food items
    }

    @PostMapping("/new")
    public String saveFoodItem(@ModelAttribute FoodItem foodItem) {
        foodItemService.saveFoodItem(foodItem);
        return "redirect:/food-items";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Optional<FoodItem> foodItem = foodItemService.getFoodItemById(id);
        foodItem.ifPresent(value -> model.addAttribute("foodItem", value));
        return "foodItems/edit"; // Assuming you have an "edit" Thymeleaf template
    }

    @PostMapping("/edit/{id}")
    public String updateFoodItem(@PathVariable int id, @ModelAttribute FoodItem foodItem) {
        foodItem.setId(id);
        foodItemService.updateFoodItem(foodItem);
        return "redirect:/food-items";
    }


    @GetMapping("/delete/{id}")
    public String deleteFoodItem(@PathVariable int id) {
        foodItemService.deleteFoodItem(id);
        return "redirect:/food-items";
    }

    @GetMapping("/basket/list")
    public String displayBasketList(Model model) {
        List<Basket> baskets = basketService.getAllBaskets();
        int total=0;
        for (int i = 0; i <baskets.size() ; i++) {
            total+=baskets.get(i).getProductPrice();
        }
        model.addAttribute("baskets", baskets);
        model.addAttribute("total", String.valueOf(total));
        return "basket";
    }
}
