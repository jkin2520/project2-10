package tests;

import org.junit.Test;
import static org.junit.Assert.*;
import src.HashAlgorithm;
import src.HashUtils;


public class HashFunctionTest {
    @Test
    public void testHashFunction() {
        String input = "testString";
        String hashed = HashUtils.hash(input, HashAlgorithm.SHA256);
        assertNotNull(hashed);
    }
    @Test
    public void testHashMatchFunction() {
        String input = "testString";
        String hash = HashUtils.hash(input, HashAlgorithm.SHA256);
        assertTrue(HashUtils.matches(input, hash, HashAlgorithm.SHA256));
}
    @Test
    public void testSaltedHashFunction() {
        String input = "testString";
        String salt = "randomSalt";
        String saltedHash = HashUtils.saltedHash(input, salt, HashAlgorithm.SHA256);
        assertNotNull(saltedHash);
}   


}
