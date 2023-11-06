package lotto.domain.prize;

import lotto.domain.prize.constants.PrizeGrade;

import java.util.*;

public class FinalResults {
    private final EnumMap<PrizeGrade, Integer> finalResults;

    // Constructor
    public FinalResults(final List<PrizeGrade> prizeRanks) {
        EnumMap<PrizeGrade, Integer> results = new EnumMap<>(PrizeGrade.class);
        final PrizeGrade[] entirePrizeGradeArray = PrizeGrade.values();

        Arrays.stream(entirePrizeGradeArray)
                .forEach(grade -> putPrizeGradeCount(prizeRanks, results, grade));

        this.finalResults = results;
    }

    // Static Factory Method
    public static FinalResults from(final List<PrizeGrade> prizeRanks) {
        return new FinalResults(prizeRanks);
    }

    // Utility Method
    private void putPrizeGradeCount(
            final List<PrizeGrade> prizeRanks,
            final EnumMap<PrizeGrade, Integer> results,
            final PrizeGrade grade
    ) {
        results.put(grade,
                countPrizeGrade(prizeRanks, grade));
    }

    private Integer countPrizeGrade(
            final List<PrizeGrade> prizeRanks,
            final PrizeGrade prizeGrade
    ) {
        return (int) prizeRanks.stream()
                .filter(rank -> Objects.equals(rank, prizeGrade))
                .count();
    }

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
