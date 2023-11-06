package constants;

import java.util.Arrays;
import java.util.List;

public enum Grade {
    FIRST(6, 2000000000),
    SECOND(5.5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final double point;
    private final int prizeMoney;
    Grade(double point,int prizeMoney) {
        this.point = point;
        this.prizeMoney = prizeMoney;

    }

    public double getPoint() {
        return point;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static List<Grade> getAllGrades() {
        return Arrays.asList(Grade.values());
    }
}
