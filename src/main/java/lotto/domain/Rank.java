package lotto.domain;

import java.util.Arrays;
import java.util.function.Predicate;

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
        if (isMatchedSecondRankCondition(matchingCount, bonusNumberExistence)) {
            return SECOND;
        }
        return findByMatchingCount(matchingCount);
    }

    private static boolean isMatchedSecondRankCondition(final int matchingCount, final boolean bonusNumberExistence) {
        return matchingCount == SECOND.matchingCount && bonusNumberExistence;
    }

    private static Rank findByMatchingCount(final int matchingCount) {
        return Arrays.stream(Rank.values())
                .filter(Predicate.not(Rank::isSecond))
                .filter(rank -> matchingCount == rank.matchingCount)
                .findFirst()
                .orElse(UNRANKED);
    }

    public long totalReward(final Rank rank, final int count) {
        return (long) rank.reward * count;
    }

    public boolean isUnranked() {
        return this == UNRANKED;
    }

    public boolean isSecond() {
        return this == SECOND;
    }

    public int matchingCount() {
        return matchingCount;
    }

    public int reward() {
        return reward;
    }

}
