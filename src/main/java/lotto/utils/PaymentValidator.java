package lotto.utils;

import static lotto.enums.ExceptionMessageType.NUMBER_NOT_INTEGER;
import static lotto.enums.ExceptionMessageType.PAYMENT_INVALID_UNIT;
import static lotto.enums.ExceptionMessageType.PAYMENT_NOT_NATURAL_NUMBER;

public class PaymentValidator extends GeneralValidator {
    private static final int UNIT = 1000;

    public static void validateNaturalNumber(int number) {
        if (number < 1) {
            throw new IllegalArgumentException(PAYMENT_NOT_NATURAL_NUMBER.getMessage());
        }
    }

    public static void validateUnit(int number) {
        if (number % UNIT != 0) {
            throw new IllegalArgumentException(PAYMENT_INVALID_UNIT.getMessage());
        }
    }

}