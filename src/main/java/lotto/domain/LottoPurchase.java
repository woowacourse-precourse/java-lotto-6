package lotto.domain;

import lotto.domain.wrapper.PurchaseCount;

public class LottoPurchase {
    private final PurchaseCount purchaseCount;

    private LottoPurchase(final int count) {
        this.purchaseCount = PurchaseCount.create(count);
    }

    public static LottoPurchase create(final int count) {
        return new LottoPurchase(count);
    }

    public boolean isRunning(int count) {
        return this.purchaseCount.getCount() != count;
    }
}
