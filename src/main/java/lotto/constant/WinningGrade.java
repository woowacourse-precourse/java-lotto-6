package lotto.constant;

import java.util.Arrays;
import java.util.Optional;

public enum WinningGrade {
    FIFTH_GRADE(5_000, 3),
    FOURTH_GRADE(50_000, 4),
    THIRD_GRADE(1_500_000, 5),
    SECOND_GRADE(30_000_000, 5),
    FIRST_GRADE(2_000_000_000, 6);

    private final int prize;
    private final int matchNum;

    WinningGrade(final int prize, final int matchNum) {
        this.prize = prize;
        this.matchNum = matchNum;
    }

    public static Optional<WinningGrade> valueOfMatchNum(final int matchNum) {
        return Arrays.stream(values()).filter(value -> value.matchNum == matchNum).findAny();
    }

    public boolean isPossibleSecondWinner() {
        return this == SECOND_GRADE || this == THIRD_GRADE;
    }

    public int toPrize() {
        return this.prize;
    }

    public int toMatchNum() {
        return this.matchNum;
    }

    public boolean hasEqualValue(final WinningGrade winningGrade) {
        return this == winningGrade;
    }

    public boolean isSecondWinner() {
        return this == SECOND_GRADE;
    }
}
