package lotto.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.GradeConstant;

public class GameResult {

    private final Map<GradeConstant, Integer> gradeResult;
    private final long totalPrize;

    public GameResult(List<GradeConstant> gradeConstants) {
        gradeResult = new HashMap<>();
        initGradeResult(gradeConstants);

        totalPrize = initTotalPrize(gradeConstants);
    }

    private void initGradeResult(List<GradeConstant> gradeConstants) {
        for (GradeConstant gradeConstant : gradeConstants) {
            gradeResult.put(gradeConstant, gradeResult.getOrDefault(gradeConstant, 0) + 1);
        }
    }

    private long initTotalPrize(List<GradeConstant> gradeConstants) {
        return gradeConstants.stream()
                .mapToLong(GradeConstant::prize)
                .sum();
    }

    public Map<GradeConstant, Integer> getGrades() {
        return Collections.unmodifiableMap(gradeResult);
    }

    public long getTotalPrize() {
        return totalPrize;
    }
}