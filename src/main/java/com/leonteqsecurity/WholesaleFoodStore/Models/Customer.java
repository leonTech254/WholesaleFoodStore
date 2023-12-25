package com.leonteqsecurity.WholesaleFoodStore.Models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerID;
    private String businessName;
    private Address address;
    private String telephoneNumber;

    public Customer() {
    }

    public Customer(String businessName, Address address, String telephoneNumber) {
        this.businessName = businessName;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }

    public Customer(int customerID, String businessName, Address address, String telephoneNumber) {
        this.customerID = customerID;
        this.businessName = businessName;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }
}
