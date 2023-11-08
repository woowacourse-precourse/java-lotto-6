package lotto.model;

import java.util.List;

public class Profit {
    private final int profit;

    public Profit(int profit) {
        this.profit = profit;
    }

    public double calculateProfit(List<Result> winningResults, int purchaseAmount) {
        int totalPrize = winningResults.stream()
                .mapToInt(Result::getPrize)
                .sum();

        double profitRatio = (double) totalPrize / purchaseAmount;
        return profitRatio * 100;
    }

}
