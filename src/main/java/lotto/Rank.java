package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false),
    SECOND(5, true),
    THIRD(5, false),
    FOURTH(4, false),
    FIFTH(3, false),
    NOTHING(-1, false);

    private final int countOfMatchingNumbers;
    private final boolean isBonusNumberIncluded;

    Rank(int countOfMatchingNumbers, boolean isBonusNumberIncluded) {
        this.countOfMatchingNumbers = countOfMatchingNumbers;
        this.isBonusNumberIncluded = isBonusNumberIncluded;
    }

    public static Rank of(int count, boolean isBonusIncluded) {
        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatchingNumbers == count)
                .filter(rank -> rank.isBonusNumberIncluded == isBonusIncluded)
                .findAny()
                .orElse(NOTHING);
    }
}