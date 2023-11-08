package lotto.dto.response;

import java.util.EnumMap;
import java.util.Map;
import lotto.model.LottoPrize;

public class PrizeSummaryDto {
    private static final long ZERO_COUNT_OF_MATCH = 0L;

    private final Map<LottoPrize, Long> prizeSummary;

    private PrizeSummaryDto(Map<LottoPrize, Long> prizeSummary) {
        this.prizeSummary = prizeSummary;
    }

    public static PrizeSummaryDto from(Map<LottoPrize, Long> prizeSummary) {
        Map<LottoPrize, Long> orderedSummary = new EnumMap<>(LottoPrize.class);
        for (LottoPrize prize : LottoPrize.values()) {
            addWinningPrizeToSummary(prizeSummary, prize, orderedSummary);
        }

        return new PrizeSummaryDto(orderedSummary);
    }

    private static void addWinningPrizeToSummary(Map<LottoPrize, Long> prizeSummary, LottoPrize prize,
                                                 Map<LottoPrize, Long> orderedSummary) {
        if (prize.isWinningPrize()) {
            Long count = prizeSummary.getOrDefault(prize, ZERO_COUNT_OF_MATCH);
            orderedSummary.put(prize, count);
        }
    }

    public Map<LottoPrize, Long> getPrizeSummary() {
        return prizeSummary;
    }
}
