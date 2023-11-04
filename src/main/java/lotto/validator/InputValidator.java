package lotto.validator;

import lotto.message.ExceptionMessage;

import java.util.regex.Pattern;

public class InputValidator {
    private static final String DIGIT_REGEX = "^[0-9]+$";

    public void validateIsDigit(String number) {
        if (!Pattern.matches(DIGIT_REGEX, number)) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_DIGIT.toString());
        }
    }
}
