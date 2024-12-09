import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashFunctionTest {
    @Test
    void testHashFunction() {
        String input = "testString";
        String hashed = HashUtils.hash(input, HashAlgorithm.SHA256);
        assertNotNull(hashed);
    }
}
