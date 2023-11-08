package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public final class PrizeSummary {
    private final Map<LottoPrize, Long> summary;

    private PrizeSummary(Map<LottoPrize, Long> summary) {
        this.summary = new EnumMap<>(summary);
    }

    public static PrizeSummary from(Map<LottoPrize, Long> summary) {
        return new PrizeSummary(summary);
    }

    public TotalProfitRate generateTotalProfitRate(InvestmentMoney investmentMoney) {
        long prizesAmount = sumPrizesAmount();
        TotalPrizeAmount totalPrizeAmount = TotalPrizeAmount.from(prizesAmount);

        return investmentMoney.calculateTotalProfitRate(totalPrizeAmount);
    }

    private long sumPrizesAmount() {
        return summary.entrySet()
                .stream()
                .mapToLong(entry -> calculatePrizeAmount(entry.getKey(), entry.getValue()))
                .sum();
    }

    private long calculatePrizeAmount(LottoPrize lottoPrize, Long count) {
        return lottoPrize.calculatePrizeAmount(count);
    }

    public Map<LottoPrize, Long> getSummary() {
        return new EnumMap<>(summary);
    }
}
