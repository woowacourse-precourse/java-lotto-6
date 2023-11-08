package lotto.service;

import lotto.domain.prize.constants.PrizeGrade;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;

public class FinalResultService {
    private FinalResultService() {
    }

    public static EnumMap<PrizeGrade, Integer> generateResult(List<PrizeGrade> prizeGrades) {
        EnumMap<PrizeGrade, Integer> results = new EnumMap<>(PrizeGrade.class);
        PrizeGrade[] entirePrizeGradeArray = PrizeGrade.values();

        Arrays.stream(entirePrizeGradeArray)
                .forEach(grade -> putPrizeGradeCount(prizeGrades, results, grade));

        return results;
    }

    private static void putPrizeGradeCount(
            List<PrizeGrade> prizeGrades,
            EnumMap<PrizeGrade, Integer> results,
            PrizeGrade grade
    ) {
        results.put(grade,
                countPrizeGrade(prizeGrades, grade));
    }

    private static Integer countPrizeGrade(
            List<PrizeGrade> prizeGrades,
            PrizeGrade prizeGrade
    ) {
        return (int) prizeGrades.stream()
                .filter(grade -> Objects.equals(grade, prizeGrade))
                .count();
    }

}
