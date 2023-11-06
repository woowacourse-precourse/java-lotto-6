package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public final class PrizeSummary {
    private static final long ZERO_COUNT_OF_MATCH = 0L;
    private final Map<LottoPrize, Long> prizeSummary;

    private PrizeSummary(Map<LottoPrize, Long> prizeSummary) {
        this.prizeSummary = new EnumMap<>(prizeSummary);
    }

    public static PrizeSummary from(Map<LottoPrize, Long> prizeSummary) {
        return new PrizeSummary(prizeSummary);
    }

    public TotalProfitRate calculateTotalProfitRate(InvestmentMoney investmentMoney) {
        long prizesAmount = sumPrizesAmount();
        TotalPrizeAmount totalPrizeAmount = TotalPrizeAmount.from(prizesAmount);

        return investmentMoney.calculateTotalProfitRate(totalPrizeAmount);
    }

    private long sumPrizesAmount() {
        return prizeSummary.entrySet()
                .stream()
                .mapToLong(entry -> calculateTotalPrizeAmount(entry.getKey(), entry.getValue()))
                .sum();
    }

    public long calculateTotalPrizeAmount(LottoPrize lottoPrize, Long count) {
        return lottoPrize.calculatePrizeAmount(count);
    }

    public long getMatchCountForPrize(LottoPrize lottoPrize) {
        return prizeSummary.getOrDefault(lottoPrize, ZERO_COUNT_OF_MATCH);
    }
}
