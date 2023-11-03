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

    public Map<LottoPrize, Long> getPrizeSummary() {
        return prizeSummary;
    }
}
