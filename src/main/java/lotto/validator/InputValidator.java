package lotto.validator;

import java.util.regex.Pattern;
import lotto.constant.ErrorMessage;

public class InputValidator {

    private static final Pattern COMMA_SEPARATED_INTEGERS_PATTERN = Pattern.compile(
        "^-?\\d+(,-?\\d+)*$");

    public static void validateIsInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ErrorMessage.NON_INTEGER_ERROR.getMessage());
        }
    }

    public static void validateCommaSeparatedIntegers(String input) {
        if (COMMA_SEPARATED_INTEGERS_PATTERN.matcher(input).matches()) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.COMMA_SEPARATED_INTEGERS.getMessage());
    }
}
