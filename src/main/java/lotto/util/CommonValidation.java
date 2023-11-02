package lotto.util;

import static lotto.util.Constants.INITIAL_VALUE;
import static lotto.util.Constants.NUMBER_REGEXP;
import static lotto.util.Constants.BLANK;

public class CommonValidation {
    private CommonValidation(){}

    public static boolean isZero(final String input) {
        return input.equals(INITIAL_VALUE);
    }
    public static boolean isNumber(final String input) {
        return input.matches(NUMBER_REGEXP);
    }
    public static boolean isBlank(final String input) {
        return input.equals(BLANK);
    }
}
