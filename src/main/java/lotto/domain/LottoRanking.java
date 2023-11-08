package lotto.domain;

import java.util.Arrays;

public enum LottoRanking {
    ZERO(0, false, 0L),
    THREE(3, false, 5_000L),
    FOUR(4, false, 50_000L),
    FIVE(5, false, 1_500_000L),
    FIVE_AND_BONUS(5, true, 30_000_000L),
    SIX(6, false, 2_000_000_000L);

    private final int winningCount;
    private final boolean matchBonus;
    private final long prizeMoney;

    LottoRanking(int winningCount, boolean isMatchBonus, long prizeMoney) {
        this.winningCount = winningCount;
        this.matchBonus = isMatchBonus;
        this.prizeMoney = prizeMoney;
    }

}
