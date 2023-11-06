package lotto.domain.prize;

import lotto.domain.prize.constants.PrizeGrade;

import java.util.*;

public class FinalResults {
    private final EnumMap<PrizeGrade, Integer> finalResults;

    public FinalResults(List<PrizeGrade> prizeRanks) {
        EnumMap<PrizeGrade, Integer> results = new EnumMap<>(PrizeGrade.class);
        PrizeGrade[] entirePrizeGradeArray = PrizeGrade.values();

        Arrays.stream(entirePrizeGradeArray)
                .forEach(grade -> results.put(grade, countPrizeGrade(prizeRanks, grade)));
        this.finalResults = results;
    }

    public static FinalResults from(List<PrizeGrade> prizeRanks) {
        return new FinalResults(prizeRanks);
    }

    public Integer countPrizeGrade(List<PrizeGrade> prizeRanks, PrizeGrade prizeGrade) {
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

    public EnumMap<PrizeGrade, Integer> getFinalResults() {
        return finalResults;
    }
}
