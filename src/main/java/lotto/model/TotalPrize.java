package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public final class TotalPrize {
    private static final long ZERO_COUNT_OF_MATCH = 0L;
    private final Map<LottoPrize, Long> prizeSummary;

    private TotalPrize(Map<LottoPrize, Long> prizeSummary) {
        this.prizeSummary = new EnumMap<>(prizeSummary);
    }

    public static TotalPrize from(Map<LottoPrize, Long> prizeSummary) {
        return new TotalPrize(prizeSummary);
    }

    public TotalProfitRate calculateTotalProfitRate(InvestMoney investMoney) {
        long totalWinningMoney = calculateTotalWinningMoney();
        TotalWinningMoney winningMoney = TotalWinningMoney.from(totalWinningMoney);
        double totalProfitRate = investMoney.calculateTotalProfitPercentage(winningMoney);

        return TotalProfitRate.from(totalProfitRate);
    }

    private long calculateTotalWinningMoney() {
        return prizeSummary.entrySet()
                .stream()
                .mapToLong(entry -> {
                    LottoPrize lottoPrize = entry.getKey();
                    Long prizeCount = entry.getValue();
                    return lottoPrize.calculatePrizeAmount(prizeCount);
                })
                .sum();
    }

    public long countMatchesForPrize(LottoPrize lottoPrize) {
        return prizeSummary.getOrDefault(lottoPrize, ZERO_COUNT_OF_MATCH);
    }

}
