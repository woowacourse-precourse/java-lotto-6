package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

    private final Map<LottoPrize, Integer> statistics = new EnumMap<>(LottoPrize.class);
    private final long totalPrize;
    private final long purchaseAmount;

    public LottoStatistics(List<LottoResult> results) {
        this.purchaseAmount = calculatePurchaseAmount(results);
        initializeStatistics();

        long calculatedTotalPrize = 0;

        for (LottoResult result : results) {
            LottoPrize prize = LottoPrize.valueOf(result.matchCount(), result.bonusMatch());
            statistics.put(prize, statistics.get(prize) + 1);
            calculatedTotalPrize += prize.getPrizeMoney();
        }

        this.totalPrize = calculatedTotalPrize;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (LottoPrize prize : LottoPrize.values()) {
            if (prize == LottoPrize.NONE) {
                continue;
            }
            int count = statistics.get(prize);
            result.append(String.format("%s - %d개%n", prize.getPrizeDescription(), count));
        }

        result.append(String.format("총 수익률은 %.1f%%입니다.", ((double) totalPrize) / purchaseAmount * 100));
        return result.toString();
    }

    private long calculatePurchaseAmount(List<LottoResult> results) {
        return ((long) LottoPurchaseAmount.AMOUNT_PER_TICKET) * results.size();
    }

    private void initializeStatistics() {
        for (LottoPrize prize : LottoPrize.values()) {
            statistics.put(prize, 0);
        }
    }
}
