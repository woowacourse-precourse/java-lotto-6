package lotto.model;

import java.util.Map;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank valueOf(int matchCount, boolean hasBonusNumber) {
        if (matchCount == SECOND.matchCount && hasBonusNumber) {
            return SECOND;
        }
        if (matchCount == THIRD.matchCount) {
            return THIRD;
        }
        for (Rank rank : values()) {
            if (matchCount == rank.matchCount) {
                return rank;
            }
        }
        return NONE;
    }

    public static int calculateTotalPrize(Map<Rank, Integer> resultCount) {
        int totalPrize = 0;
        for (Rank rank : values()) {
            totalPrize += rank.getPrize() * resultCount.get(rank);
        }
        return totalPrize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
