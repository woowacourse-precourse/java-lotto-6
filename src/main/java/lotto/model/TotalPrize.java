package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public final class TotalPrize {
    private final Map<LottoPrize, Long> prizeCounts;

    private TotalPrize(Map<LottoPrize, Long> prizeCounts) {
        this.prizeCounts = new EnumMap<>(prizeCounts);
    }

    public static TotalPrize from(Map<LottoPrize, Long> prizeCounts) {
        return new TotalPrize(prizeCounts);
    }

    @Override
    public String toString() {
        return "TotalPrize{" +
                "prizeCounts=" + prizeCounts +
                '}';
    }
}
