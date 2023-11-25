package lotto.validator;

import static lotto.message.ErrorMessage.NOT_BLANK;
import static lotto.message.ErrorMessage.NOT_INTEGER;

public class GlobalValidator {

    public static void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER.getMessage());
        }
    }

    public static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(NOT_BLANK.getMessage());
        }
    }

}
