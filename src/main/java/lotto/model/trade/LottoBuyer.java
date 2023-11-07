package lotto.model.trade;

import static lotto.exception.LottoException.LESS_THAN_MINIMUM_PURCHASE_AMOUNT;
import static lotto.exception.LottoException.MORE_THAN_MAXIMUM_PURCHASE_AMOUNT;
import static lotto.exception.LottoException.NOT_VALID_PURCHASE_AMOUNT_UNIT;

public class LottoBuyer {
    private static final int ZERO_AMOUNT = 0;
    private static final int PURCHASE_AMOUNT_UNIT = 1000;
    private static final int MINIMUM_PURCHASE_AMOUNT = 1000;
    private static final int MAXIMUM_PURCHASE_AMOUNT = 20000;
    private int purchaseAmount;

    public LottoBuyer() {
        this.purchaseAmount = ZERO_AMOUNT;
    }

    public void pay(final int purchaseAmount) {
        validateAmountUnit(purchaseAmount);
        validateIsLessThanMinimumPurchaseAmount(purchaseAmount);
        validateIsMoreThanMaximumPurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public int getCountOfLotto() {
        return purchaseAmount / PURCHASE_AMOUNT_UNIT;
    }

    private void validateAmountUnit(final int purchaseAmount) {
        if (isNotDividedByPurchaseAmountUnit(purchaseAmount)) {
            NOT_VALID_PURCHASE_AMOUNT_UNIT.throwException();
        }
    }

    private boolean isNotDividedByPurchaseAmountUnit(final int purchaseAmount) {
        return purchaseAmount % PURCHASE_AMOUNT_UNIT != 0;
    }

    private void validateIsLessThanMinimumPurchaseAmount(final int purchaseAmount) {
        if (purchaseAmount < MINIMUM_PURCHASE_AMOUNT) {
            LESS_THAN_MINIMUM_PURCHASE_AMOUNT.throwException();
        }
    }

    private void validateIsMoreThanMaximumPurchaseAmount(final int purchaseAmount) {
        if (purchaseAmount > MAXIMUM_PURCHASE_AMOUNT) {
            MORE_THAN_MAXIMUM_PURCHASE_AMOUNT.throwException();
        }
    }
}
