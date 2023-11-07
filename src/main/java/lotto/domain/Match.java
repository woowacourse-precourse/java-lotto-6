package lotto.domain;

import java.util.Arrays;
import java.util.function.Predicate;

public enum Match {
    NONE(0, 0),
    THREE(3, 5000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000);

    private final int matchCount;
    private final int prizeMoney;

    Match(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int matchCount() {
        return matchCount;
    }

    public static Match match(int matchCount, boolean bonus) {
        if (matchCount == FIVE.matchCount && bonus) {
            return FIVE_BONUS;
        }
        return valueOfMatch(matchCount);
    }

    private static Match valueOfMatch(int matchCount) {
        return Arrays.stream(Match.values())
                .filter(Predicate.not(Match::isFIVE_BONUS))
                .filter(value -> value.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    private boolean isFIVE_BONUS() {
        return this == FIVE_BONUS;
    }
}
