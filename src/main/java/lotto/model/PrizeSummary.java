package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public final class PrizeSummary {
    private static final long ZERO_COUNT_OF_MATCH = 0L;
    private final Map<LottoPrize, Long> summary;

    private PrizeSummary(Map<LottoPrize, Long> summary) {
        this.summary = new EnumMap<>(summary);
    }

    public static PrizeSummary from(Map<LottoPrize, Long> summary) {
        return new PrizeSummary(summary);
    }

    public TotalProfitRate calculateTotalProfitRate(InvestmentMoney investmentMoney) {
        long prizesAmount = sumPrizesAmount();
        TotalPrizeAmount totalPrizeAmount = TotalPrizeAmount.from(prizesAmount);

        return investmentMoney.calculateTotalProfitRate(totalPrizeAmount);
    }

    private long sumPrizesAmount() {
        return summary.entrySet()
                .stream()
                .mapToLong(entry -> calculateTotalPrizeAmount(entry.getKey(), entry.getValue()))
                .sum();
    }

    public long calculateTotalPrizeAmount(LottoPrize lottoPrize, Long count) {
        return lottoPrize.calculatePrizeAmount(count);
    }

    public long getMatchCountForPrize(LottoPrize lottoPrize) {
        return summary.getOrDefault(lottoPrize, ZERO_COUNT_OF_MATCH);
    }
}
