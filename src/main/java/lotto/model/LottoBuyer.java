package lotto.model;

import static lotto.utils.LottoException.*;

public class LottoBuyer {
    private static final int ZERO_AMOUNT = 0;
    private static final int PURCHASE_AMOUNT_UNIT = 1000;
    private int purchaseAmount;

    public LottoBuyer() {
        this.purchaseAmount = ZERO_AMOUNT;
    }

    public void pay(final int purchaseAmount) {
        validateAmountUnit(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validateAmountUnit(int purchaseAmount) {
        if (isNotDividedByPurchaseAmountUnit(purchaseAmount)) {
            NOT_VALID_PURCHASE_AMOUNT_UNIT.throwException();
        }
    }

    private boolean isNotDividedByPurchaseAmountUnit(int purchaseAmount) {
        return purchaseAmount % PURCHASE_AMOUNT_UNIT != 0
    }
}
