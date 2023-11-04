package lotto.validation;

import java.util.regex.Pattern;

public class AmountValidator {

    private static final String DIGIT_REGEX = "^[0-9]+$";
    private AmountValidator() {
    }

    public static void validateAmount(String amount) {
        isDigit(amount);
    }

    private static void isDigit(String amount) {
        if (!Pattern.matches(DIGIT_REGEX, amount)) {
            throw AmountException.INVALID_DIGIT_EXCEPTION.getException();
        }
    }
}
