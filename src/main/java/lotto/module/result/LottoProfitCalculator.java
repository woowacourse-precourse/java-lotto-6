package lotto.module.result;

import lotto.module.domain.LottoProfit;
import lotto.module.domain.PurchaseAmount;
import lotto.module.domain.TotalPrize;

public class LottoProfitCalculator {
    private static final double MULTIPLIER = 100.0;

    private LottoProfitCalculator() {
    }

    public static LottoProfitCalculator newInstance() {
        return new LottoProfitCalculator();
    }

    public LottoProfit getProfitRate(PurchaseAmount purchaseAmount, TotalPrize totalPrize) {
        int payment = purchaseAmount.getPayment();
        long money = totalPrize.money();
        double result = (double) money / payment;
        return new LottoProfit(result * MULTIPLIER);
    }

}
