package lotto.domain;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoConstants;

public record PurchaseAmount(int amount) {

    private static final int MIN_PURCHASE_AMOUNT = 1_000;
    private static final int MAX_PURCHASE_AMOUNT = 100_000;

    public PurchaseAmount {
        validateRange(amount);
        validateUnit(amount);
    }

    private void validateRange(int amount) {
        if (isLessThanMinimumAmount(amount) || isGreaterThanMaximumAmount(amount)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_RANGE.getMessage()
                    .formatted(MIN_PURCHASE_AMOUNT, MAX_PURCHASE_AMOUNT));
        }
    }

    private boolean isLessThanMinimumAmount(int amount) {
        return amount < MIN_PURCHASE_AMOUNT;
    }

    private boolean isGreaterThanMaximumAmount(int amount) {
        return amount > MAX_PURCHASE_AMOUNT;
    }

    private void validateUnit(int amount) {
        if (isNotDividedByLottoPrice(amount)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT.getMessage());
        }
    }

    private boolean isNotDividedByLottoPrice(int amount) {
        return amount % LottoConstants.LOTTO_PRICE.getValue() != 0;
    }
}
