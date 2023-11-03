package lotto.service;

import lotto.model.LottoPrize;

import java.util.List;

public class Calculator {

    public Double calculatePrize(List<LottoPrize> lottoPrizes) {
        return (double) sumPrize(lottoPrizes) / sumPurchaseAmount(lottoPrizes);
    }

    private int sumPurchaseAmount(List<LottoPrize> lottoPrizes) {
        return lottoPrizes.size() * 1000;
    }

    private long sumPrize(List<LottoPrize> lottoPrizes) {
        return lottoPrizes.stream()
                .mapToLong(LottoPrize::getPrize)
                .sum();
    }
}
