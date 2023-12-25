package com.leonteqsecurity.WholesaleFoodStore.Respository.Interface;

import com.leonteqsecurity.WholesaleFoodStore.Models.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> findAllCustomers();
    Customer findCustomer(int customerId);
    boolean deleteCustomer(int customerId);
    boolean updateCustomer(Customer customer);
    boolean addCustomer(Customer customer);
}
