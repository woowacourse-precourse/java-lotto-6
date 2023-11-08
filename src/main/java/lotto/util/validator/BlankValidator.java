package lotto.util.validator;

import static lotto.util.message.ErrorMessages.BLANK_EXCEPTION;

public final class BlankValidator {
    private BlankValidator() {
    }

    public static void validate(String value) {
        validateBlank(value);
    }

    private static void validateBlank(String value) {
        if (isBlank(value)) {
            throw new IllegalArgumentException(BLANK_EXCEPTION);
        }
    }

    private static boolean isBlank(String value) {
        return value.isBlank();
    }
}
