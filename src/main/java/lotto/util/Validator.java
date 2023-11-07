package lotto.util;

import lotto.message.ErrorMessage;

public class Validator {
    public static void validateDigit(String str) throws IllegalArgumentException {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER);
        }
    }

    public static void validateAmountInThousands(int amount) throws IllegalArgumentException {
        int THOUSAND = 1000;
        if (amount % THOUSAND != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT);
        }
    }
}
