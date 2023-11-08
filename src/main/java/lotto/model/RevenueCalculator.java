package lotto.model;

import java.util.Map;

public class RevenueCalculator {
    public long calculateEarnings(Map<WinningStatistics, Long> winningStatistics) {
        return winningStatistics.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }

    public double calculateEarningRate(Map<WinningStatistics, Long> winningStatistics, int buyPrice) {
        long totalEarnings = calculateEarnings(winningStatistics);
        double earningRate = ((double) totalEarnings / buyPrice) * 100;
        return Math.round(earningRate * 100) / 100.0;
    }
}
