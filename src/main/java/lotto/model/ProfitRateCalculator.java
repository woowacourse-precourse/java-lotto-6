package lotto.model;

import java.util.List;

public class ProfitRateCalculator {
    private final int totalPurchasePrice;
    private final List<WinningResult> winningResults;

    public ProfitRateCalculator(int totalPurchasePrice, List<WinningResult> winningResults) {
        this.totalPurchasePrice = totalPurchasePrice;
        this.winningResults = winningResults;
    }

    public double calculateProfitRate() {
        int totalWinningAmount = winningResults.stream()
                .mapToInt(this::calculateWinningAmount)
                .sum();

        return (double) totalWinningAmount / totalPurchasePrice;
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
}
