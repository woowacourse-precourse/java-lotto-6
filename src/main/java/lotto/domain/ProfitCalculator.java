package lotto.domain;

import lotto.constants.Values;

public class ProfitCalculator {
    private final WinningStatistics winningStatistics;
    private final double totalInvestment;

    public ProfitCalculator(WinningStatistics winningStatistics, PurchasedLottos purchasedLottos) {
        this.winningStatistics = winningStatistics;
        this.totalInvestment = purchasedLottos.getPurchaseAmount();
    }

    public double calculateProfitRate() {
        double totalWinnings = winningStatistics.calculateTotalPrizeAmount();
        double profitRate = (totalWinnings / totalInvestment) * Values.PERCENTAGE_FACTOR;
        profitRate = Math.round(profitRate * Values.PERCENTAGE_FACTOR) / Values.PERCENTAGE_FACTOR;
        return profitRate;
    }
}
