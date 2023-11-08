package lotto;

import java.util.EnumMap;
import java.util.Map;

public class PrizeResults {
    private final Map<PrizeCategory, Integer> results;

    public PrizeResults() {
        this.results = new EnumMap<>(PrizeCategory.class);
        for (PrizeCategory category : PrizeCategory.values()) {
            results.put(category, 0);
        }
    }

    public void addResult(int matchCount, boolean hasBonus) {
        PrizeCategory category = PrizeCategory.valueOf(matchCount, hasBonus);
        results.merge(category, 1, Integer::sum);
    }

    public void printResults() {
        results.forEach((category, count) -> {
            if (category != PrizeCategory.NONE) {
                System.out.println(category.getMatchText() + " - " + count + "개");
            }
        });
    }

    public int calculateTotalPrize() {
        return results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeAmount() * entry.getValue())
                .sum();
    }
}
