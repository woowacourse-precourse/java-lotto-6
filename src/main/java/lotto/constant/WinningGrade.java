package lotto.constant;

import java.util.Arrays;
import java.util.Optional;

public enum WinningGrade {
    FIRST_GRADE(2_000_000_000, 6),
    SECOND_GRADE(30_000_000, 5),
    THIRD_GRADE(1_500_000, 5),
    FOURTH_GRADE(50_000, 4),
    FIFTH_GRADE(5_000, 3);

    private final int amount;
    private final int matchNum;

    WinningGrade(final int amount, final int matchNum) {
        this.amount = amount;
        this.matchNum = matchNum;
    }

    public static Optional<WinningGrade> valueOfMatchNum(final int matchNum) {
        return Arrays.stream(values()).filter(value -> value.matchNum == matchNum).findAny();
    }

    public boolean isPossibleSecondWinner() {
        return this == SECOND_GRADE || this == THIRD_GRADE;
    }

    public int toAmount() {
        return this.amount;
    }
}
