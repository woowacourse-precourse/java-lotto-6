package lotto;

import java.math.BigDecimal;
import lotto.domain.LottoPurchaseManager;

public class Application {
    public static void main(String[] args) {
        LottoPurchaseManager lottoPurchaseManager = new LottoPurchaseManager(BigDecimal.valueOf(1000));
        lottoPurchaseManager.runPurchase();
    }
}
