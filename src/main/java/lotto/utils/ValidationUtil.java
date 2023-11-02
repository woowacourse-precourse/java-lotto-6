package lotto.utils;

import static lotto.contents.ContentErrors.INVALID_AMOUNT;
import static lotto.contents.ContentErrors.NEGATIVE_AMOUNT;
import static lotto.contents.ContentNumbers.LOTTO_PRICE;
import static lotto.contents.ContentNumbers.ZERO;

public class ValidationUtil {
    public static void validateNonNegative(int amount) {
        if (amount < ZERO.getNumber()) {
            throw new IllegalArgumentException(NEGATIVE_AMOUNT.getErrorMessage());
        }
    }

    public static void validateThousandUnit(int amount) {
        if (amount % LOTTO_PRICE.getNumber() != ZERO.getNumber()) {
            throw new IllegalArgumentException(INVALID_AMOUNT.getErrorMessage());
        }
    }
}
