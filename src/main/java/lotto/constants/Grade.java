package lotto.constants;

import java.util.Arrays;
import java.util.List;

public enum Grade {
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) - %d개"),
    SECOND(5.5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    THIRD(5, 1500000, "5개 일치 (1,500,000원) - %d개"),
    FOURTH(4, 50000, "4개 일치 (50,000원) - %d개"),
    FIFTH(3, 5000, "3개 일치 (5,000원) - %d개");

    private final double point;
    private final int prizeMoney;
    private final String message;

    Grade(double point, int prizeMoney, String message) {
        this.point = point;
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    public double getPoint() {
        return point;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getMessage() {
        return message;
    }

    public static List<Grade> getAllGrades() {
        return Arrays.asList(Grade.values());
    }
}
