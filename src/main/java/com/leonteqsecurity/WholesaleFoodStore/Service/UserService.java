package com.leonteqsecurity.WholesaleFoodStore.Service;

import com.leonteqsecurity.WholesaleFoodStore.Models.Role;
import com.leonteqsecurity.WholesaleFoodStore.Models.User;
import com.leonteqsecurity.WholesaleFoodStore.Respository.Interface.UserRepository;
import com.leonteqsecurity.WholesaleFoodStore.Security.PasswordEncryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing User entities in the Wholesale Food Store application.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    /**
     * Constructor for UserService.
     *
     * @param userRepository The repository for managing User entities.
     */
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retrieves all users from the repository.
     *
     * @return List of all users.
     */
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Finds a user by their ID.
     *
     * @param userId The ID of the user to find.
     * @return The found user or null if not found.
     */
    public User findUser(int userId) {
        return userRepository.findUser(userId);
    }

    /**
     * Deletes a user by their ID.
     *
     * @param userId The ID of the user to delete.
     * @return True if the user is deleted, false otherwise.
     */
    public boolean deleteUser(int userId) {
        return userRepository.deleteUser(userId);
    }

    /**
     * Updates a user in the repository.
     *
     * @param user The user with updated information.
     * @return True if the user is updated, false otherwise.
     */
    public boolean updateUser(User user) {
        return userRepository.updateUser(user.getUsername(), user.getPassword(), user.getRole().name(), user.getId());
    }

    /**
     * Adds a new user to the repository.
     *
     * @param user The user to add.
     * @return True if the user is added, false otherwise.
     */
    public boolean addUser(User user) {
        String rawPassword = user.getPassword();
        String encryptedPassword = PasswordEncryption.encryptPassword(rawPassword);
        user.setPassword(encryptedPassword);
        userRepository.addUser(user.getUsername(), user.getPassword(), String.valueOf(Role.User));
        return true;
    }

    /**
     * Validates user credentials for login.
     *
     * @param user The user attempting to log in.
     * @return True if login is successful, false otherwise.
     */
    public boolean loginUser(User user) {
        Optional<User> userOptional = userRepository.userlogin(user.getUsername());
        if (userOptional.isPresent()) {
            User userDB = userOptional.get();
            return PasswordEncryption.validatePassword(user.getPassword(), userDB.getPassword());
        } else {
            return false;
        }
    }
}
