package lotto.model;

import lotto.validator.PurchaseAmountValidator;

public class PurchaseAmount {
    private static final int LOTTO_AMOUNT_UNIT = 1000;
    private int purchaseAmount;

    private PurchaseAmount(int purchaseAmount) {
        // 여기서 1000원 단위의 유효성 검사 해야함
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount getInstance(int purchaseAmount) {
        return new PurchaseAmount(purchaseAmount);
    }

    public int getLottoNum() {
        return purchaseAmount / LOTTO_AMOUNT_UNIT;
    }
}
