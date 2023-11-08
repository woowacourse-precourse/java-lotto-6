package lotto.domain;

import java.util.List;

public class Profit {
    private final double profit;

    private Profit(double profit) {
        this.profit = profit;
    }

    public static Profit from(List<MatchingCase> matchingResult, int purchase) {
        double profit = caculateProfit(matchingResult, purchase);
        return new Profit(profit);
    }

    private static double caculateProfit(List<MatchingCase> matchingResult, int purchase) {
        int totalPrize = calculateTotalPrize(matchingResult);
        return (double) totalPrize / purchase * 100;
    }

    private static int calculateTotalPrize(List<MatchingCase> matchingResult) {
        return matchingResult.stream()
                .mapToInt(MatchingCase::calculatePrize)
                .sum();
    }

    public double getProfit() {
        return profit;
    }
}
