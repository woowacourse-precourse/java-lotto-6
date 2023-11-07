package lotto.validator;

import java.util.regex.Pattern;

public class InputValidator {
    public static final String NUMBER_REGEX = "^[0-9]+$";

    public static Boolean isEmpty(final String input) {
        return input.isEmpty();
    }

    public static boolean isMatchedNumberRegex(final String input) {
        return Pattern.matches(NUMBER_REGEX, input);
    }
}
