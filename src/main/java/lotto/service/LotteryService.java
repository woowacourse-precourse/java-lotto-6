package lotto.service;

import lotto.model.LottoPurchaseAmount;

public class LotteryService implements Service {
    private LotteryService() {
    }

    public static LotteryService create() {
        return new LotteryService();
    }

    @Override
    public void buyLottery(final String inputPurchaseAmount) {
        LottoPurchaseAmount purchaseAmount = LottoPurchaseAmount.from(inputPurchaseAmount);
    }
}
