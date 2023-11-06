package lotto.validator;

import static lotto.view.ViewConstant.NUMBER_PATTERN;
import static lotto.view.ViewConstant.WINNING_NUMBER_PATTERN;

public class Validator {

    public static void validateNumeric(String input) {
        if (input.matches(NUMBER_PATTERN.value())) {
            return;
        }
        throw new IllegalArgumentException(Error.NOT_NUMERIC_INPUT.message());
    }

    public static void validateWinningNumbersInput(String input) {
        if (input.matches(WINNING_NUMBER_PATTERN.value())) {
            return;
        }
        throw new IllegalArgumentException(Error.INVALID_FORMAT_WINNING_NUMBERS.message());
    }

}
