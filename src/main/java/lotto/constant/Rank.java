package lotto.constant;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean hasBonus;
    private final long prize;

    Rank(int matchCount, boolean hasBonus, long prize) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prize = prize;
    }

    public static Rank findRank(int matchCount, boolean hasBonusMatch) {
        return Arrays.stream(values())
            .filter(rank -> rank.matchCount == matchCount)
            .filter(rank -> !rank.hasBonus || hasBonusMatch)
            .findFirst()
            .orElse(NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }
}
