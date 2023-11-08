package lotto.service;

public class LottoProfitCalculator {

    public double calculateProfitRate(int[] matchCounts, int payMoney, long[] prizeAmounts) {
        long totalPrize = calculateTotalPrize(matchCounts, prizeAmounts);
        return (double) totalPrize / (payMoney) * 100.0;
    }

    private long calculateTotalPrize(int[] matchCounts, long[] prizeAmounts) {
        long totalPrize = 0;
        for (int i = 0; i < matchCounts.length; i++) {
            totalPrize += matchCounts[i] * prizeAmounts[i];
        }
        return totalPrize;
    }
}

