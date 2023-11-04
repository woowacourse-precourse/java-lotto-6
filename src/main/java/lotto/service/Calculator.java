package lotto.service;

import lotto.model.LottoPrize;
import lotto.model.PurchaseAmount;

import java.util.List;

public class Calculator {

    public Double calculatePrize(List<LottoPrize> lottoPrizes, PurchaseAmount purchaseAmount) {
        return (double) sumPrize(lottoPrizes) / purchaseAmount.getAmount();
    }

    private long sumPrize(List<LottoPrize> lottoPrizes) {
        return lottoPrizes.stream()
                .mapToLong(LottoPrize::getPrize)
                .sum();
    }
}
