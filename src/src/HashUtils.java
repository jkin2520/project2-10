package src;
import java.security.MessageDigest;

public class HashUtils {
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
    public static boolean matches(String input, String hash, HashAlgorithm algorithm) {
        return hash.equals(hash(input, algorithm));
    }
    public static String saltedHash(String input, String salt, HashAlgorithm algorithm) {
        return hash(input + salt, algorithm);
    }
    
}
