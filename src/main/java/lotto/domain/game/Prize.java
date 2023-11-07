package lotto.domain.game;

import java.util.stream.Stream;

public enum Prize {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000),

    NONE(0, false, 0);

    private final int matchCount;
    private final boolean isMatchWithBonus;
    private final int prizeMoney;

    Prize(final int matchCount, final boolean isMatchWithBonus, final int prizeMoney) {
        this.matchCount = matchCount;
        this.isMatchWithBonus = isMatchWithBonus;
        this.prizeMoney = prizeMoney;
    }

    public static Prize of(final int matchCount, final boolean isMatchWithBonus) {
        return Stream.of(Prize.values())
                .filter(prize -> prize.checkIfMatch(matchCount, isMatchWithBonus))
                .findAny()
                .orElse(NONE);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    private boolean checkIfMatch(final int matchCount, final boolean isMatchWithBonus) {
        if (this.isMatchWithBonus) {
            return this.matchCount == matchCount && this.isMatchWithBonus == isMatchWithBonus;
        }

        return this.matchCount == matchCount;
    }
}
