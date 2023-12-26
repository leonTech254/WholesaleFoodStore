package com.leonteqsecurity.WholesaleFoodStore.Respository.Interface;

import com.leonteqsecurity.WholesaleFoodStore.Models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing User entities in the Wholesale Food Store application.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Retrieves all users from the repository.
     *
     * @return List of all users.
     */
    @Query(value = "SELECT * FROM users", nativeQuery = true)
    List<User> findAllUsers();

    /**
     * Finds a user by their ID.
     *
     * @param userId The ID of the user to find.
     * @return The found user or null if not found.
     */
    @Query(value = "SELECT * FROM users WHERE id = :userId", nativeQuery = true)
    User findUser(@Param("userId") int userId);

    /**
     * Retrieves a user by their username.
     *
     * @param username The username of the user to retrieve.
     * @return Optional containing the found user or empty if not found.
     */
    @Query(value = "SELECT * FROM users WHERE username = :username", nativeQuery = true)
    Optional<User> userlogin(@Param("username") String username);

    /**
     * Deletes a user by their ID.
     *
     * @param userId The ID of the user to delete.
     * @return True if the user is deleted, false otherwise.
     */
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM users WHERE id = :userId", nativeQuery = true)
    boolean deleteUser(@Param("userId") int userId);

    /**
     * Updates a user in the repository.
     *
     * @param username The new username.
     * @param password The new password.
     * @param role     The new role.
     * @param userId   The ID of the user to update.
     * @return True if the user is updated, false otherwise.
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET username = :username, password = :password, role = :role WHERE id = :userId", nativeQuery = true)
    boolean updateUser(@Param("username") String username, @Param("password") String password, @Param("role") String role, @Param("userId") int userId);

    /**
     * Adds a new user to the repository.
     *
     * @param username The username of the new user.
     * @param password The password of the new user.
     * @param role     The role of the new user.
     */
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO users (username, password, role) VALUES (:username, :password, :role)", nativeQuery = true)
    void addUser(@Param("username") String username, @Param("password") String password, @Param("role") String role);
}
