package lotto.util;

import lotto.constant.ConfigurationNumbers;
import lotto.constant.ExceptionMessage;

public class Validator {
    private static final String POSITIVE_INT = "\\d+";

    public static void lessThanPrice(int num) {
        if (num < ConfigurationNumbers.PRICE.getNumber()) {
            throw new IllegalArgumentException(ExceptionMessage.LESS_THAN_PRICE.getMessage());
        }
    }

    public static void divisibleByPrice(int num) {
        if (num % ConfigurationNumbers.PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(ExceptionMessage.CAN_NOT_DIVIDE.getMessage());
        }
    }

    public static void isNumber(String input) {
        if (!input.matches(POSITIVE_INT)) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_NUMBER.getMessage());
        }
    }
}
