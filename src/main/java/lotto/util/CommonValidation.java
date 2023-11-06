package lotto.util;

import static lotto.util.Constants.INITIAL_VALUE;
import static lotto.util.Constants.NUMBER_REGEXP;
import static lotto.util.Constants.BLANK;
import static lotto.util.exception.ErrorMessage.INVALID_ZERO_NUMBER;
import static lotto.util.exception.ErrorMessage.INVALID_STRING;
import static lotto.util.exception.ErrorMessage.INVALID_BLANK;

public class CommonValidation {
    private CommonValidation(){}

    public static void validate(final String input) {
        isContainsBlank(input);
        isNumber(input);
        isZero(input);
    }
    private static void isZero(final String input) {
        if(input.equals(INITIAL_VALUE)) throw new IllegalArgumentException(INVALID_ZERO_NUMBER.getErrorMessage());
    }
    private static void isNumber(final String input) {
        if(!input.matches(NUMBER_REGEXP)) throw new IllegalArgumentException(INVALID_STRING.getErrorMessage());
    }
    private static void isContainsBlank(final String input) {
        if(input.contains(BLANK)) throw new IllegalArgumentException(INVALID_BLANK.getErrorMessage());
    }
}
