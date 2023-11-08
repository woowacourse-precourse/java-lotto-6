package lotto.model;

import lotto.model.constant.PurchaseAmountConstants;

public class PurchaseAmount {
    private final int amount;
    private int count;

    public PurchaseAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void lottoCount() {
        count = amount / PurchaseAmountConstants.PURCHASE_AMOUNT_UNIT.getNumber();
    }
}
