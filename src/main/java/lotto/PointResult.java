package lotto;

import constants.Grade;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PointResult {
    private final HashMap<Double, Integer> pointResult = new HashMap<>();

    public PointResult(List<Double> pointResult) {
        initPointResult(pointResult);
    }

    public int getCountByGrade(Grade grade) {
        return pointResult.get(grade.getPoint());
    }

    private void initPointResult(List<Double> pointResult) {
        for(Grade grade : Grade.getAllGrades()) {
            int frequency = Collections.frequency(pointResult, grade.getPoint());
            this.pointResult.put(grade.getPoint(), frequency);
        }
    }
}
