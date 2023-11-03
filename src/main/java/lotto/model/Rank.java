package lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NO_RANK(-1, false, 0);

    private final int matchingCount;
    private final boolean isBonusNumberMatch;
    private final int prize;

    private Rank(int matchingCount, boolean isBonusNumberMatch, int prize) {
        this.matchingCount = matchingCount;
        this.isBonusNumberMatch = isBonusNumberMatch;
        this.prize = prize;
    }

    public static Rank decideRank(int matchingCount, boolean isBonusNumberMatch) {
        return Arrays.stream(Rank.values())
                .filter(rank -> matchingCount == rank.matchingCount)
                .filter(rank -> isBonusNumberMatch == rank.isBonusNumberMatch)
                .findAny()
                .orElse(Rank.NO_RANK);
    }
}
