package lotto.view;

import static lotto.exception.ErrorMessage.INPUT_IS_NULL;
import static lotto.exception.ErrorMessage.INPUT_IS_EMPTY;

import lotto.exception.Exception;

public class InputValidator {

    public static void validateInput(String input) {
        checkNull(input);
        checkEmpty(input);
    }

    private static void checkNull(String input) {
        if (isNull(input)) {
            throw Exception.of(INPUT_IS_NULL);
        }
    }

    private static void checkEmpty(String input) {
        if (!hasValue(input)) {
            throw Exception.of(INPUT_IS_EMPTY);
        }
    }

    private static boolean isNull(String input) {
        return input == null;
    }

    private static boolean hasValue(String input) {
        return !input.isBlank();
    }
}