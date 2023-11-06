package lotto;

import static lotto.constant.ViewConstant.NUMBER_PATTERN;

public class Validator {

    public static void validateNumeric(String input) {
        if (input.matches(NUMBER_PATTERN.value())) {
            return;
        }
        throw new IllegalArgumentException();
    }
}
