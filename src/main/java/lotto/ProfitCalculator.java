package lotto;

import java.util.List;

public class ProfitCalculator {

    public double calculateProfit(WinningStats winningStats) {
        int totalWinnings = calculateTotalWinnings(winningStats);
        int totalSpent = winningStats.getTotalTickets() * Lotto.TICKET_PRICE;
        return calculateEarningRate(totalWinnings, totalSpent);
    }

    private int calculateTotalWinnings(WinningStats winningStats) {
        int totalWinnings = 0;
        totalWinnings += calculatePrize(winningStats.getThreeMatchCount(), 5_000);
        totalWinnings += calculatePrize(winningStats.getFourMatchCount(), 50_000);
        totalWinnings += calculatePrize(winningStats.getFiveMatchCount(), 1_500_000);
        totalWinnings += calculatePrize(winningStats.getFiveAndBonusMatchCount(), 30_000_000);
        totalWinnings += calculatePrize(winningStats.getSixMatchCount(), 2_000_000_000);
        return totalWinnings;
    }

    private int calculatePrize(int matchCount, int prize) {
        return matchCount * prize;
    }

    private double calculateEarningRate(int totalWinnings, int totalSpent) {
        return ((double) totalWinnings / totalSpent) * 100;
    }
}
