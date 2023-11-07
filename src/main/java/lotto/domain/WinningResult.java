package lotto.domain;

import java.util.Arrays;

public enum WinningResult {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NOTHING(0, 0, false);

    private final int matchCount;
    private final int winningMoney;
    private final boolean matchBonusNumber;

    WinningResult(int matchCount, int winningMoney, boolean matchBonusNumber) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
        this.matchBonusNumber = matchBonusNumber;
    }

    public static WinningResult valueOf(int matchCount, boolean matchBonusNumber) {
        if (matchCount < FIFTH.matchCount) {
            return NOTHING;
        }

        if (matchCount == SECOND.matchCount && matchBonusNumber == SECOND.matchBonusNumber) {
            return SECOND;
        }

        return findWinningResult(matchCount, matchBonusNumber);
    }

    private static WinningResult findWinningResult(int matchCount, boolean matchBonusNumber) {
        return Arrays.stream(WinningResult.values())
                .filter(winningResult -> winningResult.isMatchCount(matchCount))
                .filter(winningResult -> winningResult.isMatchBonusNumber(matchBonusNumber))
                .findAny()
                .orElseGet(() -> NOTHING);
    }

    private boolean isMatchBonusNumber(boolean matchBonusNumber) {
        if (this.matchBonusNumber == matchBonusNumber) return true;
        return false;
    }

    private boolean isMatchCount(int matchCount) {
        if (this.matchCount == matchCount) return true;
        return false;
    }
}
