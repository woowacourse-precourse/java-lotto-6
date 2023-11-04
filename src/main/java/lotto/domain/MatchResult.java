package lotto.domain;

import static lotto.domain.constant.NumberConstant.*;

public enum MatchResult {
    NONE(0),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private int count;

    MatchResult(int count) {
        this.count = count;
    }

    public static MatchResult fromCount(int count) {
        if (count >= MIN_WIN_COUNT && count <= MAX_WIN_COUNT)
            return values()[count - COUNT_IDX_OFFSET];
        else
            return NONE;
    }
}
