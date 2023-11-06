package lotto.domain.prize;

import lotto.domain.prize.constants.PrizeGrade;

import java.util.EnumMap;
import java.util.List;

public class FinalResults {
    private final EnumMap<PrizeGrade, Integer> finalResults;

    public FinalResults(List<PrizeGrade> prizeRanks) {
        EnumMap<PrizeGrade, Integer> results = new EnumMap<>(PrizeGrade.class);
        prizeRanks.forEach(rank -> results.put(rank, rank.getPrizeAmount()));

        this.finalResults = results;
    }

    public static FinalResults from(List<PrizeGrade> prizeRanks) {
        return new FinalResults(prizeRanks);
    }

    public long calculateFinalRevenueAmount() {
        return finalResults.values()
                .stream()
                .mapToLong(Integer::longValue)
                .sum();
    }

    public EnumMap<PrizeGrade, Integer> getPrizeGradeCount() {
        EnumMap<PrizeGrade, Integer> gradeCount = new EnumMap<>(PrizeGrade.class);
        final int incrementValue = 1;

        finalResults.forEach((key, value) -> {
            boolean isPositivePrizeAmount = key.hasPositivePrizeAmount();
            if (isPositivePrizeAmount) {
                gradeCount.merge(key, incrementValue, Integer::sum);
            }
        });
        return gradeCount;
    }
}
