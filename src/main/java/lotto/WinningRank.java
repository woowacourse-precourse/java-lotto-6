package lotto;

import java.util.Arrays;

public enum WinningRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NO_WIN(0, 0);

    private final int countOfMatchingNumbers;
    private final long prize;

    WinningRank(int countOfMatchingNumbers, long prize) {
        this.countOfMatchingNumbers = countOfMatchingNumbers;
        this.prize = prize;
    }

    public int getCountOfMatchingNumbers() {
        return countOfMatchingNumbers;
    }

    public long getPrizeAmount() {
        return prize;
    }

    public static WinningRank from(int countOfMatchingNumbers, boolean isBonusMatched) {
        if (THIRD.matches(countOfMatchingNumbers) && !isBonusMatched) {
            return THIRD;
        }

        return Arrays.stream(values())
                .filter(winningRank -> winningRank.matches(countOfMatchingNumbers))
                .findFirst()
                .orElse(NO_WIN);
    }

    private boolean matches(int countOfMatchingNumbers) {
        return this.countOfMatchingNumbers == countOfMatchingNumbers;
    }
}

