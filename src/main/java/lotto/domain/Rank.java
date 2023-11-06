package lotto.domain;

import java.util.Arrays;

public enum Rank {
    UNRANKED(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int matchingCount;
    private final int reward;

    Rank(final int matchingCount, final int reward) {
        this.matchingCount = matchingCount;
        this.reward = reward;
    }

    public static Rank find(final int matchingCount, final boolean bonusNumberExistence) {
        if (isSecond(matchingCount, bonusNumberExistence)) {
            return SECOND;
        }
        if (isThird(matchingCount, bonusNumberExistence)) {
            return THIRD;
        }
        return findByMatchingCount(matchingCount);
    }

    private static boolean isSecond(final int matchingCount, final boolean bonusNumberExistence) {
        return matchingCount == SECOND.matchingCount && bonusNumberExistence;
    }

    private static boolean isThird(final int matchingCount, final boolean bonusNumberExistence) {
        return matchingCount == THIRD.matchingCount && !bonusNumberExistence;
    }

    private static Rank findByMatchingCount(final int matchingCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> matchingCount == rank.matchingCount)
                .findFirst()
                .orElse(UNRANKED);
    }

    public long totalReward(final Rank rank, final int count) {
        return (long) rank.reward * count;
    }

    public boolean isUnranked(final Rank rank) {
        return rank.equals(UNRANKED);
    }

    public boolean isSecond(final Rank rank) {
        return rank.equals(SECOND);
    }

    public int matchingCount() {
        return matchingCount;
    }

    public int reward() {
        return reward;
    }

}
