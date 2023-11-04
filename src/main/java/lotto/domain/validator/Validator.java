package lotto.domain.validator;

import lotto.domain.constants.LottoConstraint;
import lotto.exception.LottoException;

import java.util.Objects;

import static lotto.exception.ErrorMessage.PAYMENT_NOT_DIVISIBLE_BY_UNIT_PRICE;

public class Validator {
    private Validator() {
    }

    public static void validateUnitPrice(final int purchasePrice) {
        if (isNotDivisibleByUnitPrice(purchasePrice)) {
            throw LottoException.from(PAYMENT_NOT_DIVISIBLE_BY_UNIT_PRICE);
        }
    }

    private static boolean isNotDivisibleByUnitPrice(final int purchasePrice) {
        return !Objects.equals(purchasePrice % LottoConstraint.UNIT_PRICE.getValue(), 0);
    }
}
