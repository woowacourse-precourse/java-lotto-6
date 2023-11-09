package lotto;

import java.util.*;
import lotto.MatchNumber;

public class ProfitCalculator {
    private Map<MatchNumber, Integer> matchCounts;
    private Map<MatchNumber, Integer> prizeMap;
    private int purchasePrice;

    public ProfitCalculator(int purchasePrice, Map<MatchNumber, Integer> matchCounts) {
        this.purchasePrice = purchasePrice;
        this.matchCounts = matchCounts;
        initializePrizeMap();
    }

    private void initializePrizeMap() {
        prizeMap = new EnumMap<>(MatchNumber.class);
        prizeMap.put(MatchNumber.THREE, 5000);
        prizeMap.put(MatchNumber.FOUR, 50000);
        prizeMap.put(MatchNumber.FIVE, 1500000);
        prizeMap.put(MatchNumber.FIVE_WITH_BONUS, 30000000);
        prizeMap.put(MatchNumber.SIX, 2000000000);
    }

    public double calculateProfitRate() {
        long totalPrize = matchCounts.entrySet().stream()
                .mapToLong(entry -> entry.getValue() * prizeMap.getOrDefault(entry.getKey(), 0))
                .sum();

        return ((double) totalPrize / purchasePrice) * 100;
    }

}
