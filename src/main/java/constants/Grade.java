package constants;

import java.util.Arrays;
import java.util.List;

public enum Grade {
    FIRST(6),
    SECOND(5.5),
    THIRD(5),
    FOURTH(4),
    FIFTH(3);

    private final double point;

    Grade(double point) {
        this.point = point;
    }

    public double getPoint() {
        return point;
    }

    public static List<Grade> getAllGrades() {
        return Arrays.asList(Grade.values());
    }
}
