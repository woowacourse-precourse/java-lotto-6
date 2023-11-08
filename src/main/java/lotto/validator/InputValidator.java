package lotto.validator;

import static lotto.message.ErrorMessage.NUMBER_COMMA_USING;
import static lotto.message.ErrorMessage.ONLY_NUMBER_USING;

public class InputValidator {
    private final static String ONLY_NUMBER = "^[0-9]+$";
    private final static String NUMBERANDCOMMA = "^[0-9]+(,[0-9]+)*$";

    public static void validateNumber(String input) {
        if (!input.matches(ONLY_NUMBER)) {
            throw new IllegalArgumentException(ONLY_NUMBER_USING.getErrorMessage());
        }
    }

    public static void validateWinNumberRequirement(String input) {
        if (!input.matches(NUMBERANDCOMMA)) {
            throw new IllegalArgumentException(NUMBER_COMMA_USING.getErrorMessage());
        }
    }
}
