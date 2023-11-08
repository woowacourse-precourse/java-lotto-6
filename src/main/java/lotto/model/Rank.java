package lotto.model;

import java.util.Arrays;

public enum Rank {
    NO_MATCH(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    private final int matchCount;
    private final long reward;
    private final boolean hasBonusNumber;

    Rank(int matchCount, long reward, boolean hasBonusNumber) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static Rank findRankByMatchCount(int countOfMatch, boolean hasBonus) {
        if (countOfMatch == SECOND.matchCount && hasBonus) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == countOfMatch)
                .findFirst()
                .orElse(NO_MATCH);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getReward() {
        return reward;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }
}
