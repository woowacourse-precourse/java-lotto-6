package lotto.validation;

import java.util.regex.Pattern;

public class NumberValidator {
    private static final String POSITIVE_DIGIT_REGEX = "^[1-9]+$";
    private NumberValidator() {
    }

    public void validateNumber(String number) {
        isPositiveDigit(number);
    }

    private static void isPositiveDigit(String number) {
        if (!Pattern.matches(POSITIVE_DIGIT_REGEX, number)) {
            throw new IllegalArgumentException("[ERROR] 번호는 양의 정수만 입력할 수 있습니다.");
        }
    }
}
