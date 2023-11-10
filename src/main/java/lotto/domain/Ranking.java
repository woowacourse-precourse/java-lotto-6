package lotto.domain;

import java.util.Arrays;

public enum Ranking {
    NONE(0, false),
    FIFTH(3, false),
    FOURTH(4, false),
    THIRD(5, false),
    SECOND(5, true),
    FIRST(6, false);

    private final int numMatchingMainNumber;
    private final boolean hasBonusNumber;

    Ranking(int numMatchingMainNumber, boolean hasBonusNumber) {
        this.numMatchingMainNumber = numMatchingMainNumber;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static Ranking findFrom(int numMatchingMainNumber, boolean hasBonusNumber) {
        return Arrays.stream(Ranking.values()).filter(ranking -> ranking.equals(numMatchingMainNumber, hasBonusNumber))
                .findAny().orElse(NONE);
    }

    private boolean equals(int numMatchingMainNumber, boolean hasBonusNumber) {
        return this.numMatchingMainNumber == numMatchingMainNumber && this.hasBonusNumber == hasBonusNumber;
    }

    public boolean inRanking() {
        return this != NONE;
    }
}
