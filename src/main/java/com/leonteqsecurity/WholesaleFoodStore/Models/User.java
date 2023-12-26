package com.leonteqsecurity.WholesaleFoodStore.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a user in the Wholesale Food Store application.
 */
@Entity
@Table(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * Unique identifier for the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * The username of the user.
     */
    private String username;

    /**
     * The password associated with the user.
     */
    private String password;

    /**
     * The role of the user in the system.
     */
    @Enumerated(EnumType.STRING)
    private Role role;
}
