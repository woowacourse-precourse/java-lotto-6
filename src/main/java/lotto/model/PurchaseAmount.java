package lotto.model;

import lotto.model.constant.PurchaseAmountConstants;

public class PurchaseAmount {
    private final int amount;
    private final int lottoCount;

    public PurchaseAmount(int amount) {
        this.amount = amount;
        this.lottoCount = amount / PurchaseAmountConstants.PURCHASE_AMOUNT_UNIT.getNumber();
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
