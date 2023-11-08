package lotto.utils;

import static lotto.constants.MessageConstants.BLANK_INPUT_ERROR;
import static lotto.constants.MessageConstants.NULL_INPUT_ERROR;

public class InputValidator {
    public static void validateEmpty(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(BLANK_INPUT_ERROR);
        }
    }

    public static void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_INPUT_ERROR);
        }
    }
}
