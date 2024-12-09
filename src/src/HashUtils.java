package src;

import java.security.MessageDigest;
/**
 * Utility class for hashing and verifying strings.
 * 
 * This class provides methods to:
 * <ul>
 * <li>Hash a string using a specified hashing algorithm.</li>
 * <li>Verify if a string matches a given hash.</li>
 * <li>Generate a salted hash of a string.</li>
 * </ul>
 */
public class HashUtils {
    /**
     * Hashes a string using the specified algorithm.
     * 
     * @param input The string to be hashed.
     * @param algorithm The hashing algorithm to use (MD5, SHA1, or SHA256).
     * @return The hashed string in hexadecimal format.
     * @throws RuntimeException If the hashing algorithm is not supported.
     */
    public static String hash(String input, HashAlgorithm algorithm) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm.name().replace("SHA", "SHA-"));
            byte[] hashBytes = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error hashing string", e);
        }
    }
    /**
     * Verifies if a given string matches a given hash using the specified algorithm.
     * 
     * @param input The string to verify.
     * @param hash The expected hash value.
     * @param algorithm The hashing algorithm used to generate the hash.
     * @return true if the input matches the hash; false otherwise.
     */

    public static boolean matches(String input, String hash, HashAlgorithm algorithm) {
        return hash.equals(hash(input, algorithm));
    }
    /**
     * Generates a salted hash for a given string and salt using the specified algorithm.
     * 
     * @param input The string to be hashed.
     * @param salt The salt to add to the input.
     * @param algorithm The hashing algorithm to use (MD5, SHA1, or SHA256).
     * @return The salted hash in hexadecimal format.
     */
    public static String saltedHash(String input, String salt, HashAlgorithm algorithm) {
        return hash(input + salt, algorithm);
    }
    
}
