package lotto.util;

import static lotto.constants.ErrorMessage.*;

public class InputValidationUtils {

    public static void validateHasInput(String line) {
        if (line.isBlank()) {
            throw new IllegalArgumentException(CANNOT_READ_EMPTY_INPUT.getMessage());
        }
    }

    public static void validateIsIntFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
