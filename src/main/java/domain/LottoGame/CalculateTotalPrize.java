package domain.LottoGame;

import java.util.Map;

public class CalculateTotalPrize {
    public static double calculateTotalPrize(Map<Integer, Long> matchCounts) {
        double totalPrize = 0;
        totalPrize += matchCounts.getOrDefault(6, 0L) * 2_000_000_000;
        totalPrize += matchCounts.getOrDefault(-1, 0L) * 30_000_000;
        totalPrize += matchCounts.getOrDefault(5, 0L) * 1_500_000;
        totalPrize += matchCounts.getOrDefault(4, 0L) * 50_000;
        totalPrize += matchCounts.getOrDefault(3, 0L) * 5_000;
        return totalPrize;
    }
}

