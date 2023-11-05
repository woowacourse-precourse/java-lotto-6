package lotto.domain;

import java.util.Arrays;

public enum PrizeCondition {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private int matchingNumberCount;
    private boolean requiresBonusMatch;
    private long prize;

    PrizeCondition(int matchingNumberCount, boolean requiresBonusMatch, long prize) {
        this.matchingNumberCount = matchingNumberCount;
        this.requiresBonusMatch = requiresBonusMatch;
        this.prize = prize;
    }

    public static PrizeCondition findPrizeCondition(int matchingNumberCount, boolean containsBonus) {
        if (matchingNumberCount == 5) {
            return Arrays.stream(values())
                    .filter(condition -> condition.matchingNumberCount == matchingNumberCount && condition.requiresBonusMatch == containsBonus)
                    .findFirst()
                    .orElse(NONE);
        }

        return Arrays.stream(values())
                .filter(condition -> condition.matchingNumberCount == matchingNumberCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getMatchingNumberCount() {
        return matchingNumberCount;
    }

    public boolean isRequiresBonusMatch() {
        return requiresBonusMatch;
    }

    public long getPrize() {
        return prize;
    }
}
