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
        finalResults.forEach((key, value) -> gradeCount.merge(key, value, Integer::sum));
        return gradeCount;
    }
}
