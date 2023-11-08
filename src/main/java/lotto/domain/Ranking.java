package lotto.domain;

import java.util.Arrays;

public enum Ranking {
    NONE(0, 0, false),
    FIFTH(5, 3, false),
    FOURTH(4, 4, false),
    THIRD(3, 5, false),
    SECOND(2, 5, true),
    FIRST(1, 6, false);

    private final int rank;
    private final int numMatchingMainNumber;
    private final boolean hasBonusNumber;

    Ranking(int rank, int numMatchingMainNumber, boolean hasBonusNumber) {
        this.rank = rank;
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

    public int rank() {
        return this.rank;
    }
}
