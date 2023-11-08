package lotto.util;

import java.util.regex.Pattern;

public class Validator {
    private static final String REGEXP_POSITIVE_INTEGER = "^[1-9]\\d*$";

    public static void getValidatedMoney(String input) {
        if (!isPositiveInteger(input)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_POSITIVE_INTEGER.getMessage());
        }
        if (!isProperDenomination(input)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_PROPER_DENOMINATION.getMessage());
        }
    }

    private static boolean isPositiveInteger(String input) {
        return Pattern.matches(REGEXP_POSITIVE_INTEGER, input);
    }

    private static boolean isProperDenomination(String input) {
        return Integer.parseInt(input) % NumberConst.DENOMINATION == NumberConst.ZERO;
    }
}
