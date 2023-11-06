package lotto;

import lotto.domain.LottoPurchaseManager;

public class Application {
    public static void main(String[] args) {
        LottoPurchaseManager lottoPurchaseManager = new LottoPurchaseManager();
        lottoPurchaseManager.runPurchase();
    }
}
