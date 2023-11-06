package lotto.validator;

import static lotto.constant.ViewConstant.NUMBER_PATTERN;

public class Validator {

    public static void validateNumeric(String input) {
        if (input.matches(NUMBER_PATTERN.value())) {
            return;
        }
        throw new IllegalArgumentException(Error.NOT_NUMERIC_INPUT.message());
    }
}
