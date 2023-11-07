package lotto.view;

import java.util.regex.Pattern;

final class InputValidator {
    private static final Pattern NON_SPACED = Pattern.compile("^[\\S]+$");
    private static final Pattern NON_ZERO_LEADING_DIGITS = Pattern.compile("^[1-9][0-9]*$");

    private InputValidator() {
    }

    static void validateNonSpaced(String userInput) {
        if (!NON_SPACED.matcher(userInput).matches()) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력할 수 없습니다.");
        }
    }

    static void validateNonZeroLeadingDigits(String userInput) {
        if (!NON_ZERO_LEADING_DIGITS.matcher(userInput).matches()) {
            throw new IllegalArgumentException("[ERROR] 0으로 시작하지 않는 숫자만 입력할 수 있습니다.");
        }
    }
}
