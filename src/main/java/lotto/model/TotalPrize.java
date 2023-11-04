package lotto.model;

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

    public TotalProfit calculateTotalProfit(InvestMoney investMoney) {
        long totalWinningMoney = calculateTotalWinningMoney();
        TotalWinningMoney winningMoney = TotalWinningMoney.from(totalWinningMoney);
        double totalProfit = investMoney.calculateProfitPercentage(winningMoney);

        return TotalProfit.from(totalProfit);
    }

    private long calculateTotalWinningMoney() {
        return prizeSummary.entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().calculateWinningMoney(entry.getValue()))
                .sum();
    }

    public long countMatchesForPrize(LottoPrize lottoPrize) {
        return prizeSummary.getOrDefault(lottoPrize, 0L);
    }

}
