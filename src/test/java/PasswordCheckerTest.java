import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Rafa Narvaiza
 * @version 1.0
 *
 * {@code PasswordCheckerTest } Is a collection of tests for {@link PasswordChecker} designed to verify whether
 * passwords are suitable for each checker.
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PasswordCheckerTest {

    public static final String SMALLER_THAN_4_CHARS = "abc";
    public static final String EQUAL_TO_4_CHARS = "abcd";
    public static final String EQUAL_TO_5_CHARS = "abcde";
    public static final String EQUAL_TO_7_CHARS = "abcdefg";
    public static final String EQUAL_TO_7_CHARS_WITH_NUMS = "abcd1fg";
    public static final String EQUAL_TO_7_CHARS_WITH_NUMS_AND_UPPERCASE = "abCd1fg";
    public static final String BIGGER_THAN_7_CHARS = "abcdefgh";

    PasswordChecker passwordChecker = new PasswordChecker();

    @BeforeEach
    public void setUp(){
        System.out.println("@BeforeEach se ejecuta antes de cada test");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("@AfterEach se ejecuta despues de cada test\n");
    }

    @BeforeAll
    public static void setup(){
        System.out.println("@BeforeAll se ejecuta solo una vez al iniciar la ejecución de la clase\n");
    }

    @AfterAll
    public static void teardown(){
        System.out.println("@AfterAll se ejecuta una sola vez al final de la clase");
    }

    @Test
    @Order(1)
    @DisplayName("Check weak password with strings less than 4 chars")
    public void testCheckWeakPasswordSmallerThan4Chars(){
        assertFalse(passwordChecker.checkWeakPassword(SMALLER_THAN_4_CHARS));
    }

    @Test
    @Order(2)
    @DisplayName("Check weak password with strings equals to 4 chars")
    public void testCheckWeakPasswordEqualsTo4Chars(){
        assertTrue(passwordChecker.checkWeakPassword(EQUAL_TO_4_CHARS));
    }

    @Test
    @Order(3)
    @DisplayName("Check weak password with strings greater than 4 chars")
    public void testCheckWeakPasswordGreaterThan4Chars(){
        assertTrue(passwordChecker.checkWeakPassword(EQUAL_TO_5_CHARS));
    }

    @Test
    @Order(4)
    @DisplayName("Check medium password with strings less than 5 chars")
    public void testCheckMediumPasswordSmallerThan5Chars(){
        assertFalse(passwordChecker.checkMediumPassword(EQUAL_TO_4_CHARS));
    }

    @Test
    @Order(5)
    @DisplayName("Check medium password with strings equals to 5 chars")
    public void testCheckMediumPasswordEqualsTo5Chars(){
        assertTrue(passwordChecker.checkMediumPassword(EQUAL_TO_5_CHARS));
    }

    @Test
    @Order(6)
    @DisplayName("Check medium password with strings greater to 5 chars")
    public void testCheckMediumPasswordGreaterThan5Chars(){
        assertTrue(passwordChecker.checkMediumPassword(EQUAL_TO_7_CHARS));
    }

    @Test
    @Order(7)
    @DisplayName("Check strong password with strings less than 7 chars")
    public void testCheckStrongPasswordLessThank7Chars(){
        assertFalse(passwordChecker.checkStrongPassword(EQUAL_TO_5_CHARS));
    }

    @Test
    @Order(8)
    @DisplayName("Check strong password with strings equals to 7 chars, only letter")
    public void testCheckStrongPasswordEqualsTo7Chars(){
        assertFalse(passwordChecker.checkStrongPassword(EQUAL_TO_7_CHARS));
    }

    @Test
    @Order(9)
    @DisplayName("Check strong password with strings greater than 7 chars, only letter")
    public void testCheckStrongPasswordGreaterThan7Chars(){
        assertFalse(passwordChecker.checkStrongPassword(BIGGER_THAN_7_CHARS));
    }

    @Test
    @Order(10)
    @DisplayName("Check strong password with strings equals to 7 chars, with number and lowercase")
    public void testCheckStrongPasswordEqualsTo7CharsWithLowerCaseAndNumbers(){
        assertFalse(passwordChecker.checkStrongPassword(EQUAL_TO_7_CHARS_WITH_NUMS));
    }

    @Test
    @Order(11)
    @DisplayName("Check strong password with strings equals to 7 chars, with number, lowercase and uppercase")
    public void testCheckStrongPasswordEqualsTo7CharsWhitUpperLowerCaseAndNumbers(){
        assertTrue(passwordChecker.checkStrongPassword(EQUAL_TO_7_CHARS_WITH_NUMS_AND_UPPERCASE));
    }

}
