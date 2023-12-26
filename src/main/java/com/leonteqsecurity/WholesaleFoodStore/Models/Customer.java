package com.leonteqsecurity.WholesaleFoodStore.Models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

/**
 * Represents a customer in the Wholesale Food Store application.
 * This class is annotated with {@code @Entity} to indicate that it is a JPA entity,
 * and it is mapped to the "customers" table.
 */
@Builder
@Data
@Entity
@Table(name = "customers")
public class Customer {

    /**
     * The unique identifier for the customer.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerID;

    /**
     * The business name of the customer.
     */
    private String businessName;

    /**
     * The address of the customer. It is an embedded entity.
     */
    private Address address;

    /**
     * The telephone number of the customer.
     */
    private String telephoneNumber;

    /**
     * Default constructor for the Customer class.
     */
    public Customer() {
    }

    /**
     * Constructor for creating a customer with specified business name, address, and telephone number.
     *
     * @param businessName     The business name of the customer.
     * @param address          The address of the customer.
     * @param telephoneNumber  The telephone number of the customer.
     */
    public Customer(String businessName, Address address, String telephoneNumber) {
        this.businessName = businessName;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }

    /**
     * Constructor for creating a customer with specified customer ID, business name, address, and telephone number.
     *
     * @param customerID       The unique identifier for the customer.
     * @param businessName     The business name of the customer.
     * @param address          The address of the customer.
     * @param telephoneNumber  The telephone number of the customer.
     */
    public Customer(int customerID, String businessName, Address address, String telephoneNumber) {
        this.customerID = customerID;
        this.businessName = businessName;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }
}
