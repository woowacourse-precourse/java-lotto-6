package lotto.validator;

import lotto.message.ExceptionMessage;

import java.util.regex.Pattern;

public class InputValidator {
    private static final String DIGIT_REGEX = "^[0-9]+$";
    private static final String SPLIT_REGEX = "^[0-9,]+$";

    public void validateIsDigit(String number) {
        if (!Pattern.matches(DIGIT_REGEX, number)) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_DIGIT.toString());
        }
    }

    public void validateIsSplitByComma(String number) {
        if (!Pattern.matches(SPLIT_REGEX, number)) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_SEPARATED_BY_COMMA.toString());
        }
    }
}
