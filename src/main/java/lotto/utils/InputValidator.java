package lotto.utils;

import static lotto.enums.ExceptionMessageType.NUMBER_NOT_INTEGER;
import static lotto.enums.ExceptionMessageType.PAYMENT_NOT_NATURAL_NUMBER;

public class InputValidator {
    public static void validateInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_NOT_INTEGER.getMessage());
        }
    }

    public static void validateNaturalNumber(int number) {
        if (number < 1) {
            throw new IllegalArgumentException(PAYMENT_NOT_NATURAL_NUMBER.getMessage());
        }
    }
}