package lotto.util.validator;

import static lotto.exception.ExceptionMessage.INPUT_BLANK_ERROR_MESSAGE;

public class BlankValidator {
    public static void validate(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(INPUT_BLANK_ERROR_MESSAGE);
        }
    }

    private static boolean isBlank(String input) {
        return input.isBlank();
    }
}
