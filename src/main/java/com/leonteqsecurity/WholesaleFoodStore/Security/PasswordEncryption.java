package com.leonteqsecurity.WholesaleFoodStore.Security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Utility class for password encryption and validation.
 */
public class PasswordEncryption {

    /**
     * Encrypts the given password using the MD5 hashing algorithm.
     *
     * @param password The password to encrypt.
     * @return The encrypted password as a hexadecimal string.
     */
    public static String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            md.update(password.getBytes());

            // Get the hash's bytes
            byte[] bytes = md.digest();

            // Convert bytes to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }

            // Return the complete hash
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Validates an input password against a stored hashed password.
     *
     * @param inputPassword   The input password to validate.
     * @param hashedPassword  The stored hashed password for comparison.
     * @return True if the input password is valid, false otherwise.
     */
    public static boolean validatePassword(String inputPassword, String hashedPassword) {
        // Hash the input password and compare it with the stored hashed password
        String hashedInputPassword = encryptPassword(inputPassword);
        return hashedInputPassword != null && hashedInputPassword.equals(hashedPassword);
    }
}
