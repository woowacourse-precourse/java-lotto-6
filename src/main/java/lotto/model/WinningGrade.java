package lotto.model;

import java.util.Arrays;

public enum WinningGrade {
    NONE_GRADE(0, false, 0),
    FIFTH_GRADE(3, false, 5_000),
    FOURTH_GRADE(4, false, 50_000),
    THIRD_GRADE(5, false, 1_500_000),
    SECOND_GRADE(5, true, 30_000_000),
    FIRST_GRADE(6, false, 2_000_000_000);

    private static final int BONUS_MATCH_COUNT = 5;

    private final int matchedCount;
    private final boolean matchedBonusNumber;
    private final int winningPrice;

    WinningGrade(
            final int matchedCount,
            final boolean matchedBonusNumber,
            final int winningPrice
    ) {
        this.matchedCount = matchedCount;
        this.matchedBonusNumber = matchedBonusNumber;
        this.winningPrice = winningPrice;
    }

    public static WinningGrade getWinningType(
            final int matchedCount,
            final boolean matchedBonusNumber
    ) {
        return Arrays.stream(WinningGrade.values())
                .filter(type -> comparisonMatchCount(matchedCount, type))
                .filter(type -> comparisonBonusMatched(matchedCount, matchedBonusNumber, type))
                .findAny()
                .orElse(NONE_GRADE);
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public boolean isMatchedBonusNumber() {
        return matchedBonusNumber;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    private static boolean comparisonBonusMatched(int matchedCount, boolean matchedBonusNumber, WinningGrade type) {
        if (matchedCount == BONUS_MATCH_COUNT) {
            return type.isMatchedBonusNumber() == matchedBonusNumber;
        }
        return true;
    }

    private static boolean comparisonMatchCount(int matchedCount, WinningGrade type) {
        return type.getMatchedCount() == matchedCount;
    }

}
