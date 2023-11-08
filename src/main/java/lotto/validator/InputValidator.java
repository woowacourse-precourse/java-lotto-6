package lotto.validator;

import lotto.constant.ExceptionMessage;

import java.util.regex.Pattern;

public class InputValidator {

    private static final String DELIMITER_REGEXP = "^[0-9,]*$";
    private static final String NUMBER_REGEXP = "^\\d*$";

    public void validateDelimiter(String input) {
        if (!Pattern.matches(DELIMITER_REGEXP, input)) {
            ExceptionMessage exceptionMessage = ExceptionMessage.INCORRECT_DELIMITER;
            throw new IllegalArgumentException(exceptionMessage.getMessage());
        }
    }

    public void validateIsNumber(String input) {
        if (!Pattern.matches(NUMBER_REGEXP, input)) {
            ExceptionMessage exceptionMessage = ExceptionMessage.NOT_INTEGER;
            throw new IllegalArgumentException(exceptionMessage.getMessage());
        }
    }
}
