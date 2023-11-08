package lotto.domain;

import java.util.Arrays;

public enum Prize {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean isMatchBonus;
    private final long prizeMoney;

    Prize(int matchCount, boolean isMatchBonus, long prizeMoney) {
        this.matchCount = matchCount;
        this.isMatchBonus = isMatchBonus;
        this.prizeMoney = prizeMoney;
    }

    public static Prize determinePrize(int matchCount, boolean isMatchBonus) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.matchCount == matchCount)
                .filter(prize -> !prize.isMatchBonus || isMatchBonus)
                .findFirst()
                .orElse(NONE);
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}
