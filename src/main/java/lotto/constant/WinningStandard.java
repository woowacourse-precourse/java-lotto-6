package lotto.constant;

import java.util.Arrays;

public enum WinningStandard {
    FIRST_PLACE(6, false),
    SECOND_PLACE(6, true),
    THIRD_PLACE(5, false),
    FOURTH_PLACE(4, false),
    FIFTH_PLACE(4, false),
    NO_PLACE(4, false);

    private int matchCount;
    private boolean isBonusNumber;

    public static WinningStandard getMatchType(int matchCount, int bonusCount){
        return Arrays.stream(WinningStandard.values())
                .findAny()
                .orElse(NO_PLACE);
    }

    WinningStandard(int matchCount, boolean isBonusNumber) {
        this.matchCount = matchCount;
        this.isBonusNumber = isBonusNumber;
    }
}
