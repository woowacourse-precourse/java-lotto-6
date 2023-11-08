package lotto.validation;

import java.util.regex.Pattern;
import lotto.exception.ErrorType;

public class InputValidator {

    private static final Pattern ONLY_NUMBER_PATTERN = Pattern.compile("-?[0-9]+");

    public void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorType.INPUT_NOT_BLANK.getMessage());
        }
    }

    public void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorType.INPUT_NOT_EMPTY.getMessage());
        }
    }

    public void validateNumeric(String input) {
        if (!input.matches(ONLY_NUMBER_PATTERN.pattern())) {
            throw new NumberFormatException(ErrorType.INPUT_NOT_NUMERIC.getMessage());
        }
    }
}
