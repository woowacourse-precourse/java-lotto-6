package lotto.util;

import java.util.regex.Pattern;
import lotto.exception.InputExceptionConstant;

public class InputValidator {
    private static final String REGEXP_PATTERN_NUMBER = "^[\\d]*$";
    private static final String REGEXP_PATTERN_SPACE_CHAR = "^[\\s]*$";

    public static void isNaturalNumber(String number) {
        if (!Pattern.matches(REGEXP_PATTERN_NUMBER, number)) {
            throw new IllegalArgumentException(InputExceptionConstant.ONLY_NATURAL_NUMBER_IN_STRING.getText());
        }
    }

    public static void isNaturalNumber(String[] numbers) {
        for (String number : numbers) {
            if (!Pattern.matches(REGEXP_PATTERN_NUMBER, number)) {
                throw new IllegalArgumentException(
                        InputExceptionConstant.ONLY_NATURAL_NUMBER_IN_STRING_ARRAY.getText());
            }
        }
    }

    public static void hasBlank(String input) {
        if (Pattern.matches(REGEXP_PATTERN_SPACE_CHAR, input)) {
            throw new IllegalArgumentException(InputExceptionConstant.NO_BLANK_IN_STRING.getText());
        }
    }
}
