package lotto.domain;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoConstants;

public class PurchaseAmount {

    private static final int MIN_PURCHASE_AMOUNT = 1_000;
    private static final int MAX_PURCHASE_AMOUNT = 100_000;

    private int amount;

    public PurchaseAmount(int amount) {
        validateUnit(amount);
        validateRange(amount);
        this.amount = amount;
    }

    private void validateUnit(int amount) {
        if (amount % LottoConstants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT.getMessage());
        }
    }

    private void validateRange(int amount) {
        if (amount < MIN_PURCHASE_AMOUNT || amount > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_RANGE.getMessage()
                    .formatted(MIN_PURCHASE_AMOUNT, MAX_PURCHASE_AMOUNT));
        }
    }

    public int decrease(int lottoPrice) {
        amount -= lottoPrice;
        return amount;
    }

    public int getAmount() {
        return amount;
    }
}
