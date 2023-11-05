package lotto.service;

import lotto.domain.LottoPurchase;

public class LottoPurchaseService {

    public LottoPurchase createLottoPurchase(String purchaseAmount) {
        int purchaseCount = createPurchaseCount(purchaseAmount);
        return LottoPurchase.create(purchaseCount);
    }

    private int createPurchaseCount(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) / 1000;
    }
}
