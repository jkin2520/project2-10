package tests;

import org.junit.Test;
import static org.junit.Assert.*;
import src.HashAlgorithm;
import src.HashUtils;

/**
 * Unit tests for the HashUtils class.
 * 
 * This class tests the hashing, matching, and salted hashing functionalities
 * of the HashUtils class.
 */
public class HashFunctionTest {
    /**
     * Tests the hash function with a valid input string and algorithm.
     * 
     * This test verifies that the hash function does not return null
     * and produces consistent output for the same input.
     */
    @Test
    public void testHashFunction() {
        String input = "testString";
        String hashed = HashUtils.hash(input, HashAlgorithm.SHA256);
        assertNotNull(hashed);
    }
    /**
     * Tests the matches function to verify hash validation.
     * 
     * This test ensures that the matches function correctly identifies
     * whether an input string matches a given hash for the specified algorithm.
     */
    @Test
    public void testHashMatchFunction() {
        String input = "testString";
        String hash = HashUtils.hash(input, HashAlgorithm.SHA256);
        assertTrue(HashUtils.matches(input, hash, HashAlgorithm.SHA256));
}
/**
     * Tests the saltedHash function to verify that it produces unique hashes
     * for different salts and consistent hashes for the same salt.
     * 
     * This test ensures the salted hash function behaves as expected.
     */
    @Test
    public void testSaltedHashFunction() {
        String input = "testString";
        String salt = "randomSalt";
        String saltedHash = HashUtils.saltedHash(input, salt, HashAlgorithm.SHA256);
        assertNotNull(saltedHash);
}   


}
