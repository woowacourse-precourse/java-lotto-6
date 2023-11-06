package lotto.domain;

import static lotto.domain.constant.NumberConstant.*;
import static lotto.domain.constant.StringConstant.*;

public enum MatchResult {
    NONE(NONE_PRIZE_MONEY, NONE_MATCH_RESULT_MESSAGE),
    THREE(THREE_PRIZE_MONEY, THREE_MATCH_RESULT_MESSAGE),
    FOUR(FOUR_PRIZE_MONEY, FOUR_MATCH_RESULT_MESSAGE),
    FIVE(FIVE_PRIZE_MONEY, FIVE_MATCH_RESULT_MESSAGE),
    BONUS(BONUS_PRIZE_MONEY, BONUS_MATCH_RESULT_MESSAGE),
    SIX(SIX_PRIZE_MONEY, SIX__MATCH_RESULT_MESSAGE);

    private final long prizeMoney;
    private final String message;

    MatchResult(long prizeMoney, String message) {
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    public static MatchResult fromCount(int count) {
        if (count == SIX_WIN_COUNT)
            return values()[count - SIX_IDX_OFFSET];

        if (count >= MIN_WIN_COUNT)
            return values()[count - COUNT_IDX_OFFSET];

        return NONE;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public String getMessage() {
        return message;
    }
}
