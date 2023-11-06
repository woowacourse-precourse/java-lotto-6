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
        double totalProfitRate = investmentMoney.calculateTotalProfitRate(totalPrizeAmount);

        return TotalProfitRate.from(totalProfitRate);
    }

    private long sumPrizesAmount() {
        return prizeSummary.entrySet()
                .stream()
                .mapToLong(entry -> {
                    LottoPrize lottoPrize = entry.getKey();
                    Long prizeCount = entry.getValue();
                    return lottoPrize.calculatePrizeAmount(prizeCount);
                })
                .sum();
    }

    public long getMatchCountForPrize(LottoPrize lottoPrize) {
        return prizeSummary.getOrDefault(lottoPrize, ZERO_COUNT_OF_MATCH);
    }

}
