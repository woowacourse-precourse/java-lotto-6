package lotto.model;

import java.util.Arrays;

public enum Rank {
    NO_RANK(-1, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int matchingCount;
    private final int prize;

    private Rank(int matchingCount, int prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public static Rank decideRank(int matchingCount, boolean isBonusNumberMatch) {
        if (matchingCount == Rank.SECOND.matchingCount && isBonusNumberMatch) {
            return Rank.SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> matchingCount == rank.matchingCount)
                .filter(rank -> rank != Rank.SECOND)
                .findAny()
                .orElse(Rank.NO_RANK);
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrize() {
        return prize;
    }
}
