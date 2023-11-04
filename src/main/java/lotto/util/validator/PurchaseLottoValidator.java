package lotto.util.validator;

import lotto.util.ExceptionMessage;

public class PurchaseLottoValidator implements Validatable {
    @Override
    public void validate(int purchase) throws IllegalArgumentException {
        validatePurchaseLottoRange(purchase);
        validatePurchaseLottoUnit(purchase);
    }

    private static void validatePurchaseLottoRange(int purchase) {
        if (purchase < Range.MIN_PURCHASE_LOTTO.value) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_PURCHASE_MIN_RANGE.getMessage());
        }
        if (purchase > Range.MAX_PURCHASE_LOTTO.value) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_PURCHASE_MAX_RANGE.getMessage());
        }
    }

    private static void validatePurchaseLottoUnit(int purchase) {
        if (purchase % Range.LOTTO_UNIT.value != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_PURCHASE_UNIT.getMessage());
        }
    }

    private enum Range {
        LOTTO_UNIT(1000),
        MIN_PURCHASE_LOTTO(1000),
        MAX_PURCHASE_LOTTO(2147483000);

        private final int value;

        Range(int value) {
            this.value = value;
        }
    }
}
