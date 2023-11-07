package lotto.domain.result;

import java.util.ArrayList;
import java.util.List;
import lotto.io.write.OutputWriter;

public class Statistics {

    private List<GradeCount> gradeCounts = new ArrayList<>();

    public Statistics() {
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

    public void print() {
        for (GradeCount gradeCount : gradeCounts) {
            if (gradeCount.getGrade() == Grade.NONE) {
                continue;
            }
            OutputWriter.showStatistics(gradeCount.getGrade(), gradeCount.getCount());
        }
    }

    public List<GradeCount> getGradeCounts() {
        return gradeCounts;
    }
}
