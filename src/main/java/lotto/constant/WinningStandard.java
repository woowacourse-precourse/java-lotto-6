package lotto.constant;

import java.util.Arrays;

public enum WinningStandard {
    FIRST_PLACE(6, 0),
    SECOND_PLACE(5, 1),
    THIRD_PLACE(5, 0),
    FOURTH_PLACE(4, 0),
    FIFTH_PLACE(3, 0),
    NO_PLACE(0, 0);

    private int matchCount;
    private int bonusCount;

    public static WinningStandard getMatchType(int matchCount, int bonusCount){
        return Arrays.stream(WinningStandard.values())
                .findAny()
                .orElse(NO_PLACE);
    }

    WinningStandard(int matchCount, int bonusCount) {
        this.matchCount = matchCount;
        this.bonusCount = bonusCount;
    }
}
