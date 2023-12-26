package com.leonteqsecurity.WholesaleFoodStore.Models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Represents an address in the Wholesale Food Store application.
 * This class is annotated with {@code @Embeddable} to indicate that it can be embedded
 * in other entities.
 */
@AllArgsConstructor
@Builder
@Data
@Embeddable
public class Address {

    /**
     * The first line of the address.
     */
    private String addressLine1;

    /**
     * The second line of the address.
     */
    private String addressLine2;

    /**
     * The third line of the address.
     */
    private String addressLine3;

    /**
     * The country of the address.
     */
    private String country;

    /**
     * The postal code of the address.
     */
    private String postCode;

    /**
     * Default constructor for Address class.
     */
    public Address() {
    }
}
