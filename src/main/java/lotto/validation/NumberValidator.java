package lotto.validation;

import java.util.regex.Pattern;

public class NumberValidator {
    private static final String POSITIVE_DIGIT_REGEX = "^[1-9]+$";

    private NumberValidator() {
    }

    public static void validateNumber(String number) {
        isBlank(number);
        isContainBlank(number);
        isPositiveDigit(number);
    }

    private static void isBlank(String winningNumber) {
        if (winningNumber.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 번호는 공백일 수 없습니다.");
        }
    }

    private static void isContainBlank(String winningNumber) {
        if (winningNumber.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 번호는 공백이 포함될 수 없습니다.");
        }
    }

    private static void isPositiveDigit(String number) {
        if (!Pattern.matches(POSITIVE_DIGIT_REGEX, number)) {
            throw new IllegalArgumentException("[ERROR] 번호는 양의 정수만 입력할 수 있습니다.");
        }
    }
}
