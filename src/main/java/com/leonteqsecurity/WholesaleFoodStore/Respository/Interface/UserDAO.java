package com.leonteqsecurity.WholesaleFoodStore.Respository.Interface;

import com.leonteqsecurity.WholesaleFoodStore.Models.User;

import java.util.List;

/**
 * Data Access Object (DAO) interface for managing User entities in the Wholesale Food Store application.
 */
public interface UserDAO {

    /**
     * Retrieves all users.
     *
     * @return List of all users.
     */
    List<User> findAllUsers();

    /**
     * Finds a user by their ID.
     *
     * @param userId The ID of the user to find.
     * @return The found user or null if not found.
     */
    User findUser(long userId);

    /**
     * Deletes a user by their ID.
     *
     * @param userId The ID of the user to delete.
     * @return True if the user is deleted, false otherwise.
     */
    boolean deleteUser(long userId);

    /**
     * Updates a user.
     *
     * @param user The user with updated information.
     * @return True if the user is updated, false otherwise.
     */
    boolean updateUser(User user);

    /**
     * Adds a new user.
     *
     * @param user The user to add.
     * @return True if the user is added, false otherwise.
     */
    boolean addUser(User user);
}
