package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FAIL(-1, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    ;

    private final int matchCount;
    private final long reward;

    Rank(int matchCount, long reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Rank of(int matchWinningNumberCount, boolean matchBonusNumber) {
        Rank rank = getRank(matchWinningNumberCount);
        return compareSecondAndThird(rank, matchBonusNumber);
    }

    private static Rank getRank(int matchWinningNumberCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchWinningNumberCount)
                .findFirst()
                .orElse(FAIL);
    }

    private static Rank compareSecondAndThird(Rank rank, boolean matchBonusNumber) {
        if ((rank == SECOND || rank == THIRD) && matchBonusNumber) {
            return SECOND;
        }
        return rank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getReward() {
        return reward;
    }
}
