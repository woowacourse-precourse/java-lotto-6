package lotto.domain.prize;

import lotto.domain.prize.constants.PrizeGrade;

import java.util.EnumMap;
import java.util.Map;

public class FinalResults {
    private final EnumMap<PrizeGrade, Integer> finalResults;

    // Constructor
    public FinalResults(final EnumMap<PrizeGrade, Integer> results) {
        this.finalResults = results;
    }

    // Static Factory Method
    public static FinalResults from(final EnumMap<PrizeGrade, Integer> results) {
        return new FinalResults(results);
    }

    // Utility Method
    public long calculateFinalRevenueAmount() {
        return finalResults.entrySet().stream()
                .map(FinalResults::calculateRevenueAmount)
                .mapToLong(Integer::longValue)
                .sum();
    }

    private static int calculateRevenueAmount(Map.Entry<PrizeGrade, Integer> entry) {
        return entry.getKey().getPrizeAmount() * entry.getValue();
    }

    // Getter
    public EnumMap<PrizeGrade, Integer> getFinalResults() {
        return finalResults;
    }
}
