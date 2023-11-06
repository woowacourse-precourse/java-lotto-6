package lotto;

import java.util.Arrays;

public enum WinningType {
    NONE(0, false, 0, ""),
    FIFTH(3, false, 5_000, "3개 일치 (5,000원) - "),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원) - "),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원) - "),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

    private final int matchedCount;
    private final boolean matchedBonusNumber;
    private final int winningPrice;
    private final String message;

    WinningType(
            int matchedCount,
            boolean matchedBonusNumber,
            int winningPrice,
            String message
    ) {
        this.matchedCount = matchedCount;
        this.matchedBonusNumber = matchedBonusNumber;
        this.winningPrice = winningPrice;
        this.message = message;
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

    public String getMessage() {
        return message;
    }
}
