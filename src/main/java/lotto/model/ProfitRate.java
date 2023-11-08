package lotto.model;

import java.util.Map;

public class ProfitRate {
    private static final int INITAL_PROFIT = 0;
    private int totalProfit = INITAL_PROFIT;
    private final int purchaseAmount;
    private final double profitRate;

    public ProfitRate(Map<WinningCriteria, Integer> lottoResult, int purchaseAmount) {
        this.totalProfit = calculateProfit(lottoResult);
        this.purchaseAmount = purchaseAmount;
        this.profitRate = calculateProfitRate();

    }

    private int calculateProfit(Map<WinningCriteria, Integer> matchResult) {
        matchResult.forEach((key, value) -> {
            while (value > 0) {
                totalProfit = WinningCriteria.valueOf(key.name()).calculate(totalProfit);
                value--;
            }
        });
        return totalProfit;
    }

    private double calculateProfitRate() {
        return (double) this.totalProfit / (double) this.purchaseAmount * 100;
    }


    public double getProfitRate() {
        return profitRate;
    }
}
