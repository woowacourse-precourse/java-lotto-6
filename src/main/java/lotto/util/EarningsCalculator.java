package lotto.util;

public class EarningsCalculator {
    private EarningsCalculator() {
    }

    public static String calculateEarningsRate(int winningAmount, int purchaseAmount) {
        double earningsRate = (double) winningAmount * 100 / purchaseAmount;
        double roundedEarningRate = Math.round(earningsRate * 100.0) / 100.0;
        return roundedEarningRate + "%";
    }
}
