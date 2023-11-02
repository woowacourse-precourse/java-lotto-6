package lotto.io.validator;

import static lotto.exception.ExceptionMessage.InputException.INPUT_MUST_BE_NUMERIC;
import static lotto.exception.ExceptionMessage.InputException.INPUT_MUST_NOT_CONTAINS_SPACE;

public abstract class InputValidator {
    protected static void validateInputHasSpace(final String userInput) {
        if (hasSpace(userInput)) {
            throw new IllegalArgumentException(INPUT_MUST_NOT_CONTAINS_SPACE.message);
        }
    }

    private static boolean hasSpace(final String userInput) {
        return userInput.chars()
                .anyMatch(Character::isWhitespace);
    }

    protected static void validateInputIsNumeric(final String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (final NumberFormatException exception) {
            throw new IllegalArgumentException(INPUT_MUST_BE_NUMERIC.message);
        }
    }
}
