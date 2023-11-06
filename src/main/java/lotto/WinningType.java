package lotto;

import java.util.Arrays;

public enum WinningType {
    NONE(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchedCount;
    private final boolean matchedBonusNumber;
    private final int winningPrice;

    WinningType(int matchedCount, boolean matchedBonusNumber, int winningPrice) {
        this.matchedCount = matchedCount;
        this.matchedBonusNumber = matchedBonusNumber;
        this.winningPrice = winningPrice;
    }

    public static WinningType getWinningType(int matchedCount, boolean matchedBonusNumber) {
        return Arrays.stream(WinningType.values())
                .filter(type -> type.getMatchedCount() == matchedCount)
                .filter(type -> type.isMatchedBonusNumber() == matchedBonusNumber)
                .findAny()
                .orElse(NONE);
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
}
