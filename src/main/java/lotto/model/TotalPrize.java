package lotto.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.EnumMap;
import java.util.Map;

public final class TotalPrize {
    private final Map<LottoPrize, Long> prizeSummary;

    private TotalPrize(Map<LottoPrize, Long> prizeSummary) {
        this.prizeSummary = new EnumMap<>(prizeSummary);
    }

    public static TotalPrize from(Map<LottoPrize, Long> prizeSummary) {
        return new TotalPrize(prizeSummary);
    }

    public double calculateTotalProfit(LottoCount lottoCount) {
        long totalWinningMoney = calculateTotalWinningMoney();
        int userMoney = lottoCount.calculateUserMoney();
        return calculateProfitPercentage(totalWinningMoney, userMoney);
    }

    private double calculateProfitPercentage(long totalWinningMoney, int userMoney) {
        BigDecimal totalWinning = new BigDecimal(totalWinningMoney);
        BigDecimal investment = new BigDecimal(userMoney);
        return totalWinning.divide(investment, MathContext.DECIMAL64)
                .multiply(BigDecimal.valueOf(100))
                .doubleValue();
    }

    private long calculateTotalWinningMoney() {
        return prizeSummary.entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().calculateWinningMoney(entry.getValue()))
                .sum();
    }

    public Map<LottoPrize, Long> getPrizeSummary() {
        return prizeSummary;
    }
}
