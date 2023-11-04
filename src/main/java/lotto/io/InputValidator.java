package lotto.io;

import java.util.regex.Pattern;
import lotto.constant.ExceptionMessage;

public class InputValidator {

    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+");

    public void validateNumeric(String input) {
        if (isNumeric(input)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMERIC_INPUT.toValue());
        }
    }

    private boolean isNumeric(String input) {
        return !NUMERIC_PATTERN.matcher(input).matches();
    }

    public void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_NULL.toValue());
        }
    }
}
