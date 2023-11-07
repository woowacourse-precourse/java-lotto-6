package lotto.domain.result;

import java.util.ArrayList;
import java.util.List;
import lotto.service.LottoOutputWriter;

public class Statistics {

    private List<GradeCount> gradeCounts = new ArrayList<>();

    public static Statistics of() {
        return new Statistics();
    }

    private Statistics() {
        for (Grade grade : Grade.values()) {
            gradeCounts.add(new GradeCount(grade));
        }
    }

    public void apply(Grade grade) {
        for (GradeCount gradeCount : gradeCounts) {
            if (gradeCount.getGrade() == grade) {
                gradeCount.increment();
            }
        }
    }

    public void print(LottoOutputWriter writer) {
        for (GradeCount gradeCount : gradeCounts) {
            if (gradeCount.getGrade() == Grade.NONE) {
                continue;
            }
            writer.showStatistics(gradeCount.getGrade(), gradeCount.getCount());
        }
    }

    public List<GradeCount> getGradeCounts() {
        return gradeCounts;
    }
}
