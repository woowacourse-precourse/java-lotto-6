package lotto.util;

import lotto.constant.ErrorMessage;
import lotto.constant.Value;

public class Validator {
    private static final int THOUSAND = Value.THOUSAND.get();
    private static final int ZERO = Value.ZERO.get();

    public static void checkPositive(int number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_ERROR.get());
        }
    }

    public static void checkThousandDivision(int number) {
        if (number % THOUSAND != ZERO || number == ZERO) {
            throw new IllegalArgumentException(ErrorMessage.THOUSAND_UNIT_ERROR.get());
        }
    }
}