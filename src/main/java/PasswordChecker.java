import java.util.regex.Pattern;

/**
 *
 * The {@code PasswordChecker} class is a set of utilities to check strings as a passwords.
 *
 * @author JJReina
 * @version 0.1
 *
 */
public class PasswordChecker {
    private static final int MIN_LENGTH_WEAK_PASS = 4;
    private static final int MIN_LENGTH_MEDIUM_PASS = 5;
    private static final int MIN_LENGTH_STRONG_PASS = 7;
    /**
     * A weak password must have at least {@value MIN_LENGTH_WEAK_PASS} characters
     * @param password String to check.
     * @return {@code true} if the characters number of  {@code password} is at least {@value MIN_LENGTH_WEAK_PASS}, otherwise
     * {@code false}
     */
    public boolean checkWeakPassword(String password) {
        return password.length() >= MIN_LENGTH_WEAK_PASS;
    }

    /**
     * A medium password must have at least {@value MIN_LENGTH_MEDIUM_PASS} characters.
     * @param password String to check.
     * @return {@code true} if the characters number of  {@code password} is at least {@value MIN_LENGTH_MEDIUM_PASS}, otherwise
     * {@code false}
     */
    public boolean checkMediumPassword(String password) {
        return password.length() >= MIN_LENGTH_MEDIUM_PASS;
    }

    /**
     * A strong password must have at least {@value MIN_LENGTH_STRONG_PASS} characters, the password must include numbers,
     * lowercase characters and uppercase characters.
     * @param password String to check.
     * @return {@code true} if the characters number of  {@code password} is at least {@value MIN_LENGTH_STRONG_PASS}
     * and include numbers, lowercase characters and uppercase characters, otherwise
     * {@code false}
     */
    public boolean checkStrongPassword(String password) {
        boolean passwordAccepted = false;
        if (password.length() >= MIN_LENGTH_STRONG_PASS
                && Pattern.compile("[0-9]").matcher(password).find()
                && Pattern.compile("[a-z]").matcher(password).find()
                && Pattern.compile("[A-Z]").matcher(password).find()) {
            passwordAccepted = true;
        }
        return passwordAccepted;
    }
}