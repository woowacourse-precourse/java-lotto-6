package lotto.domain.util;

public class InputValidator {

    public static void isNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.STRING_IS_NULL.getErrorMessage());
        }
    }

    public static void isEmptyOrBlank(String input) {
        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.STRING_IS_EMPTY_OR_BLANK.getErrorMessage());
        }
    }
}
