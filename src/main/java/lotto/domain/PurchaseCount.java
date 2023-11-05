package lotto.domain;

import static lotto.domain.lotto.LottoConstants.LOTTO_PRICE;

public class PurchaseCount {
    private static final int MIN_COUNT = 0;
    private int purchaseCount;

    public PurchaseCount(int purchaseAmount) {
        this.purchaseCount = convertAmountToCount(purchaseAmount);
    }

    private int convertAmountToCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE.getValue();
    }

    public boolean hasRemain() {
        return purchaseCount > MIN_COUNT;
    }

    public void decrement() {
        purchaseCount--;
    }
}
