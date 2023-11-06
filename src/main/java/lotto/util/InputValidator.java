package lotto.util;

import java.util.regex.Pattern;

public class InputValidator {
    private static final String REGEXP_PATTERN_NUMBER = "^[\\d]*$";
    private static final String REGEXP_PATTERN_SPACE_CHAR = "^[\\s]*$";

    public static boolean isNaturalNumber(String number) {
        return Pattern.matches(REGEXP_PATTERN_NUMBER, number);
    }

    public static boolean isNaturalNumber(String[] numbers) {
        for (String number : numbers) {
            if (!Pattern.matches(REGEXP_PATTERN_NUMBER, number)) {
                return false;
            }
        }

        return true;
    }

    public static boolean hasBlank(String input) {
        return Pattern.matches(REGEXP_PATTERN_SPACE_CHAR, input);
    }
}
