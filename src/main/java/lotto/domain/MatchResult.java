package lotto.domain;

import static lotto.domain.constant.NumberConstant.*;

public enum MatchResult {
    NONE(NONE_PRIZE_MONEY),
    BONUS(BONUS_PRIZE_MONEY),
    THREE(THREE_PRIZE_MONEY),
    FOUR(FOUR_PRIZE_MONEY),
    FIVE(FIVE_PRIZE_MONEY),
    SIX(SIX_PRIZE_MONEY);

    private final long prizeMoney;

    MatchResult(long prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public static MatchResult fromCount(int count) {
        if (count >= MIN_WIN_COUNT && count <= MAX_WIN_COUNT)
            return values()[count - COUNT_IDX_OFFSET];

        return NONE;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}
