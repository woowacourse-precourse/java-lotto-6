package lotto.util;

import lotto.constant.ErrorMessage;

public class MoneyValidator {

    private static final int LOTTO_PRICE = 1000;

    public static void validateNumber(int number) {
        if(number < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.toString());
        }
    }

    public static void validateThousand(int number) {
        if(number % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_THOUSAND.toString());
        }
    }
}
