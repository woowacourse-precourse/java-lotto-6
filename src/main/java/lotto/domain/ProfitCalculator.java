package lotto.domain;

import java.text.DecimalFormat;
import lotto.constants.Values;

public class ProfitCalculator {
    private final WinningStatistics winningStatistics;
    private final double totalInvestment;

    public ProfitCalculator(WinningStatistics winningStatistics, PurchasedLottos purchasedLottos) {
        this.winningStatistics = winningStatistics;
        this.totalInvestment = calculateTotalInvestment(purchasedLottos);
    }

    private double calculateTotalInvestment(PurchasedLottos purchasedLottos) {
        return (double) purchasedLottos.getLottos().size() * Values.LOTTO_PURCHASE_UNIT;
    }

    public String getProfitPercentage() {
        double profitRate = calculateProfitRate();
        DecimalFormat decimalFormat = new DecimalFormat(Values.PROFIT_DECIMAL_FORMAT);
        String formattedPercentage = decimalFormat.format(profitRate);
        formattedPercentage += Values.PROFIT_SYMBOL;
        return formattedPercentage;
    }

    private double calculateProfitRate() {
        double totalWinnings = winningStatistics.calculateTotalPrizeAmount();
        double profitRate = (totalWinnings / totalInvestment) * Values.PERCENTAGE_FACTOR;
        profitRate = Math.round(profitRate * Values.PERCENTAGE_FACTOR) / Values.PERCENTAGE_FACTOR;
        return profitRate;
    }
}
