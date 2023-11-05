package lotto.util;

import java.util.Arrays;

public enum LottoPrize {
    FIRST_PRIZE(1, 2_000_000_000),
    SECOND_PRIZE(2, 300_000_000),
    THIRD_PRIZE(3, 1_500_000),
    FOURTH_PRIZE(4, 50_000),
    FIFTH_PRIZE(5, 5_000)
    ;
    private final int grade;
    private final long prize;

    LottoPrize(int grade, long prize) {
        this.grade = grade;
        this.prize = prize;
    }

    public int getGrade() {
        return this.grade;
    }

    public static long getPrize(int grade) {
        return Arrays.stream(values())
                .filter(value -> value.getGrade() == grade)
                .findFirst().get().prize;
    }
}
