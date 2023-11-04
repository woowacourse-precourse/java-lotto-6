package lotto.validation;

import java.util.regex.Pattern;

public class AmountValidator {

    private static final String DIGIT_REGEX = "^[0-9]+$";
    private static final String INVALID_DIGIT_ERROR_MESSAGE = "[ERROR] 구입 금액은 정수만 입력할 수 있습니다.";
    private AmountValidator() {
    }

    public static void validateAmount(String amount) {
        isDigit(amount);
    }

    private static void isDigit(String amount) {
        if (!Pattern.matches(DIGIT_REGEX, amount)) {
            throw new IllegalArgumentException(INVALID_DIGIT_ERROR_MESSAGE);
        }
    }
}
