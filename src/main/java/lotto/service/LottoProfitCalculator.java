package lotto.service;

import lotto.constants.LottoPrize;

public class LottoProfitCalculator {


    public double calculateProfitRate(int[] matchCounts, int payMoney) {
        long totalPrize = calculateTotalPrize(matchCounts);
        return (double) totalPrize / payMoney * 100.0;
    }

    private long calculateTotalPrize(int[] matchCounts) {
        long totalPrize = 0;
        for (int i = 0; i < matchCounts.length; i++) {
            totalPrize += (long) matchCounts[i] * LottoPrize.PRIZES[i];
        }
        return totalPrize;
    }
}

