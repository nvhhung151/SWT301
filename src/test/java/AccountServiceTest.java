import hungnvh.example.AccountService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AccountServiceTest {

    private final AccountService service = new AccountService();

    @ParameterizedTest(name = "Test Register {index}: username={0}, password={1}, email={2} => expected={3}")
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    void testRegisterAccount(String username, String password, String email, boolean expected) {
        boolean result = service.registerAccount(username, password, email);
        assertEquals(expected, result,
                () -> "Register failed for: username=" + username + ", password=" + password + ", email=" + email);
    }

    @ParameterizedTest(name = "Test Email Validity {index}: email={2}")
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    void testIsValidEmail(String username, String password, String email, String expectedStr) {
        boolean expected = Boolean.parseBoolean(expectedStr);
        boolean isValid = service.isValidEmail(email);
        assertEquals(expected, isValid, "Mismatch for email: " + email);

        if (!email.contains("@") || email.startsWith("@") || email.endsWith("@")) {
            assertFalse(isValid, "Expected invalid email: " + email);
        } else {
            assertTrue(isValid, "Expected valid email: " + email);
        }
    }

}


