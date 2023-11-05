package lotto.util;

import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern POSITIVE_INTEGER_PATTERN = Pattern.compile("\\d+");

    public static void validatePurchaseAmountInput(String input) {
        validateEmptyInput(input);
        validatePositiveNumber(input);
    }

    public static void validatePositiveNumber(String input) {
        if (!isPositiveNumber(input)) {
            throw new IllegalArgumentException("[ERROR] 입력값은 숫자여야합니다.");
        }
    }

    public static void validateEmptyInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 비어있습니다.");
        }
    }

    private static boolean isPositiveNumber(String input) {
        return POSITIVE_INTEGER_PATTERN.matcher(input).matches();
    }
}
