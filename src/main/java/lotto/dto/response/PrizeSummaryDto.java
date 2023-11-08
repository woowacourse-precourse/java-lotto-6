package lotto.dto.response;

import java.util.LinkedHashMap;
import java.util.Map;
import lotto.model.LottoPrize;
import lotto.model.PrizeSummary;

public class PrizeSummaryDto {
    private final Map<LottoPrize, Long> prizeSummary;

    private PrizeSummaryDto(Map<LottoPrize, Long> prizeSummary) {
        this.prizeSummary = prizeSummary;
    }

    public static PrizeSummaryDto from(PrizeSummary prizeSummary) {
        Map<LottoPrize, Long> orderedSummary = new LinkedHashMap<>();
        for (LottoPrize prize : LottoPrize.values()) {
            addWinningPrizeToSummary(prizeSummary, prize, orderedSummary);
        }

        return new PrizeSummaryDto(orderedSummary);
    }

    private static void addWinningPrizeToSummary(PrizeSummary prizeSummary, LottoPrize prize,
                                                 Map<LottoPrize, Long> orderedSummary) {
        if (prize.isWinningPrize()) {
            Long count = prizeSummary.getMatchCountForPrize(prize);
            orderedSummary.put(prize, count);
        }
    }

    public Map<LottoPrize, Long> getPrizeSummary() {
        return prizeSummary;
    }
}
