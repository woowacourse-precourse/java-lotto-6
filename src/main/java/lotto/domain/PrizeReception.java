package lotto.domain;

import java.util.Map;
import lotto.domain.wrapper.PurchaseAmount;
import lotto.utils.LottoConstantValue;
import lotto.utils.Prize;

public class PrizeReception {
    private final Map<Prize, Integer> lottosResult;

    public PrizeReception(Map<Prize, Integer> lottosResult) {
        this.lottosResult = lottosResult;
    }

    public int getPrizeCount(Prize prize) {
        return lottosResult.getOrDefault(prize, LottoConstantValue.DEFAULT_COUNT.get());
    }

    public double getProfitRate(PurchaseAmount purchaseAmount) {
        return purchaseAmount.calculateProfitRate(getAllPrizeProfit());
    }

    private long getAllPrizeProfit() {
        long allPrizeProfit = 0;
        for (Prize prize : lottosResult.keySet()) {
            long prizeProfit = (long) prize.getPrizeProfit() * lottosResult.get(prize);
            allPrizeProfit += prizeProfit;
        }
        return allPrizeProfit;
    }
}
