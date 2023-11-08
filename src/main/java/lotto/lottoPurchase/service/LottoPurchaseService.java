package lotto.lottoPurchase.service;

import lotto.lotto.domain.Lotteries;
import lotto.lottoPurchase.domain.LottoPurchase;

public class LottoPurchaseService {

    private final LottoPurchase lottoPurchase = new LottoPurchase();

    public LottoPurchaseService() {
    }

    public Lotteries process() throws IllegalArgumentException {
        lottoPurchase.insult();
        lottoPurchase.calculate();
        System.out.println(lottoPurchase.getPurchaseAmount() + "개를 구매했습니다.");
        Lotteries lotteries = new Lotteries();
        lotteries.publishLotteries(lottoPurchase.getPurchaseAmount());
        return lotteries;
    }

}
