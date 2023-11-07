package lotto.domain;

import java.util.Arrays;

public class Profit {
    private final double profit;

    public Profit(double profit) {
        this.profit = profit;
    }

    public static Profit from(int purchase) {
        return new Profit(caculateProfit(purchase));
    }

    private static double caculateProfit(int purchase) {
        int sum = Arrays.stream(MatchingCase.values())
                .mapToInt(matchingCase -> matchingCase.getPrize() * matchingCase.getWinningCount())
                .sum();
        return (double) sum / purchase * 100;
    }

    public double getProfit() {
        return profit;
    }
}
