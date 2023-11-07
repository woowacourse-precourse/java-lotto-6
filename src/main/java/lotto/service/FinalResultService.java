package lotto.service;

import lotto.domain.prize.constants.PrizeGrade;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;

public class FinalResultService {
    private FinalResultService() {
    }

    public static EnumMap<PrizeGrade, Integer> generateResult(final List<PrizeGrade> prizeGrades) {
        EnumMap<PrizeGrade, Integer> results = new EnumMap<>(PrizeGrade.class);
        final PrizeGrade[] entirePrizeGradeArray = PrizeGrade.values();

        Arrays.stream(entirePrizeGradeArray)
                .forEach(grade -> putPrizeGradeCount(prizeGrades, results, grade));

        return results;
    }

    private static void putPrizeGradeCount(
            final List<PrizeGrade> prizeGrades,
            final EnumMap<PrizeGrade, Integer> results,
            final PrizeGrade grade
    ) {
        results.put(grade,
                countPrizeGrade(prizeGrades, grade));
    }

    private static Integer countPrizeGrade(
            final List<PrizeGrade> prizeGrades,
            final PrizeGrade prizeGrade
    ) {
        return (int) prizeGrades.stream()
                .filter(grade -> Objects.equals(grade, prizeGrade))
                .count();
    }

}
