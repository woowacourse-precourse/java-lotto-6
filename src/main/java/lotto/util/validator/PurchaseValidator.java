package lotto.util.validator;

import lotto.util.ExceptionMessage;
import lotto.util.Util;

public class PurchaseValidator implements Validatable {
    @Override
    public void validate(String input) throws IllegalArgumentException {
        int purchase = Util.convertStringToInt(input);
        validatePurchaseLottoRange(purchase);
        validatePurchaseLottoUnit(purchase);
    }

    private void validatePurchaseLottoRange(int purchase) {
        if (purchase < Range.MIN_PURCHASE_LOTTO.value) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_MIN_RANGE.getMessage());
        }
        if (purchase > Range.MAX_PURCHASE_LOTTO.value) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_MAX_RANGE.getMessage());
        }
    }

    private void validatePurchaseLottoUnit(int purchase) {
        if (purchase % Range.LOTTO_UNIT.value != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_UNIT.getMessage());
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
