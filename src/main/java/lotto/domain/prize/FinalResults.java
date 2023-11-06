package lotto.domain.prize;

import lotto.domain.prize.constants.PrizeGrade;
import lotto.view.constants.PrintablePrizeType;

import java.util.Arrays;
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
        PrintablePrizeType[] printablePrizeType = PrintablePrizeType.values();

        Arrays.stream(printablePrizeType)
                .filter(type -> type.getGrade().hasPositivePrizeAmount())
                .filter(type.getGrade().isSame)

        initializeGradeCount(gradeCount);

        return gradeCount;
    }

    private static void initializeGradeCount(EnumMap<PrizeGrade, Integer> gradeCount) {
        Arrays.stream(PrizeGrade.values())
                .forEach(grade -> gradeCount.put(grade, 0));
    }

    public boolean isSame(Prize prize1, Prize prize2) {

    }
}
