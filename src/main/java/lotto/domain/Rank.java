package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NOTHING(-1, false, 0);

    private final int countOfMatchingNumbers;
    private final boolean isBonusNumberIncluded;
    private final int prize;

    Rank(int countOfMatchingNumbers, boolean isBonusNumberIncluded, int prize) {
        this.countOfMatchingNumbers = countOfMatchingNumbers;
        this.isBonusNumberIncluded = isBonusNumberIncluded;
        this.prize = prize;
    }

    public static Rank of(int count, boolean isBonusIncluded) {
        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatchingNumbers == count)
                .filter(rank -> rank.isBonusNumberIncluded == isBonusIncluded)
                .findAny()
                .orElse(NOTHING);
    }

    public int getNumber() {
        return this.countOfMatchingNumbers;
    }

    public int getPrize() {
        return this.prize;
    }
}