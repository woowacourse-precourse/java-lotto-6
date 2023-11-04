package lotto.domain.validator;

import lotto.exception.LottoException;

import java.util.Objects;

import static lotto.exception.ErrorMessage.PAYMENT_NOT_DIVISIBLE_BY_UNIT_PRICE;

public class Validator {
    private static final int UNIT_PRICE = 1_000;

    private Validator() {
    }

    public static void validateUnitPrice(final int purchasePrice) {
        if (isNotDivisibleByUnitPrice(purchasePrice)) {
            throw LottoException.from(PAYMENT_NOT_DIVISIBLE_BY_UNIT_PRICE);
        }
    }

    private static boolean isNotDivisibleByUnitPrice(final int purchasePrice) {
        return !Objects.equals(purchasePrice % UNIT_PRICE, 0);
    }
}
