package lotto.util.validator;

import static lotto.common.ExceptionMessage.INPUT_BLANK_ERROR;

public class BlankValidator {
    public static void validate(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(INPUT_BLANK_ERROR);
        }
    }

    private static boolean isBlank(String input) {
        return input.isBlank();
    }
}
