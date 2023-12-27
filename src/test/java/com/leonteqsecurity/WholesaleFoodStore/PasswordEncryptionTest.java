//package com.leonteqsecurity.WholesaleFoodStore;
//
//import com.leonteqsecurity.WholesaleFoodStore.Security.PasswordEncryption;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//class PasswordEncryptionTest {
//
//    @Test
//    void testEncryptPassword() {
//        // Test encryption of a simple password
//        String password = "password123";
//        String encryptedPassword = PasswordEncryption.encryptPassword(password);
//        assertNotNull(encryptedPassword);
//        assertNotEquals(password, encryptedPassword);
//    }
//
//    @Test
//    void testValidatePassword() {
//        // Test validation of a correct password
//        String password = "password123";
//        String hashedPassword = PasswordEncryption.encryptPassword(password);
//        assertTrue(PasswordEncryption.validatePassword(password, hashedPassword));
//
//        // Test validation of an incorarect password
//        String incorrectPassword = "incorrectPassword";
//        assertFalse(PasswordEncryption.validatePassword(incorrectPassword, hashedPassword));
//    }
//
//    @Test
//    void testEncryptPasswordWithEmptyString() {
//        // Test encryption of an empty string
//        String password = "";
//        String encryptedPassword = PasswordEncryption.encryptPassword(password);
//        assertNotNull(encryptedPassword);
//        // The MD5 hash of an empty string should not be null, and it should be consistent
//        assertEquals(encryptedPassword, PasswordEncryption.encryptPassword(password));
//    }
//
//    @Test
//    void testValidatePasswordWithEmptyString() {
//        // Test validation of an empty string
//        String password = "";
//        String hashedPassword = PasswordEncryption.encryptPassword(password);
//        assertTrue(PasswordEncryption.validatePassword(password, hashedPassword));
//    }
//
//    @Test
//    void testValidatePasswordWithNullHashedPassword() {
//        // Test validation with a null hashed password
//        String password = "password123";
//        assertFalse(PasswordEncryption.validatePassword(password, null));
//    }
//}
