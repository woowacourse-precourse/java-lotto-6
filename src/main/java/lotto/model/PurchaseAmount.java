package lotto.model;


import lotto.utils.Constant;

import static lotto.utils.Constant.*;

public class PurchaseAmount {
    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validate(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000단위로 입력하세요");
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
