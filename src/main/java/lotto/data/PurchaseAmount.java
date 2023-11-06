package lotto.data;

import lotto.constant.Constant;

public class PurchaseAmount {
    final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchasedLottoCount() {
        return purchaseAmount / Constant.LOTTO_PRICE;
    }

    public int getAmount() {
        return purchaseAmount;
    }
}
