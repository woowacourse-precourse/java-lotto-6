package lotto.util;

import java.util.regex.Pattern;

public class InputValidator {
    private static final String REGEXP_PATTERN_NUMBER = "^[\\d]*$";
    private static final String REGEXP_PATTERN_SPACE_CHAR = "^[\\s]*$";

    public static void validatePurchaseNumber(String number) {
        isOneNaturalNumber(number);
        hasBlank(number);
    }
    public static void isOneNaturalNumber(String number) {
        if (!Pattern.matches(REGEXP_PATTERN_NUMBER, number)) {
            throw new IllegalArgumentException();
        }
    }

    public static void isNaturalNumbers(String[] numbers) {
        for (String number : numbers) {
            isOneNaturalNumber(number);
        }
    }

    public static void hasBlank(String input) {
        if (Pattern.matches(REGEXP_PATTERN_SPACE_CHAR, input)) {
            throw new IllegalArgumentException();
        }
    }
}
