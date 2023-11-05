package lotto.model;

import java.util.List;

public class ProfitRateCalculator {
    private final int totalPurchasePrice;
    private final List<WinningResult> winningResults;
    private double profitRate;

    public ProfitRateCalculator(int totalPurchasePrice, List<WinningResult> winningResults) {
        this.totalPurchasePrice = totalPurchasePrice;
        this.winningResults = winningResults;
    }

    public void calculateProfitRate() {
        int totalWinningAmount = winningResults.stream()
                .mapToInt(this::calculateWinningAmount)
                .sum();

        profitRate = (double) totalWinningAmount / totalPurchasePrice;
    }

    private int calculateWinningAmount(WinningResult winningResult) {
        return switch (winningResult.getMatchingCount()) {
            case 6 -> 2_000_000_000;
            case 5 -> winningResult.hasBonusNumber() ? 30_000_000 : 1_500_000;
            case 4 -> 50_000;
            case 3 -> 5_000;
            default -> 0;
        };
    }

    public double getProfitRate() {
        return profitRate;
    }
}
