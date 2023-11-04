package model;

import static consts.NumericConfig.LOTTO_PRICE;
import static consts.NumericConfig.PERCENT_MULTIPLIER;

public class FinanceManager {

    private final int purchaseAmount;

    private FinanceManager(final int amount) {
        this.purchaseAmount = amount;
    }

    public static FinanceManager from(final int purchase) {
        return new FinanceManager(purchase);
    }

    public int calculateLottoCount() {
        return purchaseAmount / LOTTO_PRICE.number();
    }

    public double calculateRateOfReturn(final LottoTotalResult totalResult) {
        long resultSum = totalResult.getSum();
        return (double) resultSum / purchaseAmount * PERCENT_MULTIPLIER.number();
    }
}
