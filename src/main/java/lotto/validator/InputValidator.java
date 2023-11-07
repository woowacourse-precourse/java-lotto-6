package lotto.validator;

import lotto.exception.NonDigitInputException;
import lotto.exception.NonSplitCommaException;
import lotto.message.ExceptionMessage;

import java.util.regex.Pattern;

public class InputValidator {
    private static final String DIGIT_REGEX = "^[0-9]+$";
    private static final String SPLIT_REGEX = "^[0-9,]+$";

    public void validateIsDigit(String number) {
        if (!Pattern.matches(DIGIT_REGEX, number)) {
            String message = ExceptionMessage.IS_NOT_DIGIT.toString();
            throw new NonDigitInputException(message);
        }
    }

    public void validateIsSplitByComma(String number) {
        if (!Pattern.matches(SPLIT_REGEX, number)) {
            String message = ExceptionMessage.IS_NOT_SEPARATED_BY_COMMA.toString();
            throw new NonSplitCommaException(message);
        }
    }
}
