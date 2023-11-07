package lotto.model;

import java.util.Map;

public class ProfitCalculator {

    private final double profitRatio;


    public ProfitCalculator(double purchaseMoney, Statistics statistics) {
        double totalPrize = calculateTotalPrize(statistics);
        this.profitRatio = calculateProfitRatio(purchaseMoney, totalPrize);
    }

    public double getProfitRatio() {
        return profitRatio;
    }

    public ProfitCalculator(double profitRatio) {
        this.profitRatio = profitRatio;
    }

    private double calculateProfitRatio(double purchaseMoney, double totalPrize) {
        return totalPrize / purchaseMoney * Constant.RATIO_NUMBER;
    }

    private double calculateTotalPrize(Statistics statistics) {
        double totalPrize = 0.0;

        Map<Prize, Integer> result = statistics.getResult();

        for (Map.Entry<Prize, Integer> entry : result.entrySet()) {
            Prize prize = entry.getKey();
            int matchCount = entry.getValue();
            totalPrize += prize.getPrize() * matchCount;
        }
        return totalPrize;
    }

}
