package lotto.model.constans;

import java.text.DecimalFormat;

public enum WinningRank {
    FIFTH_PRIZE(3, 5_000),
    FORTH_PRIZE(4, 50_000),
    THIRD_PRIZE(5, 1_500_000),
    SECOND_PRIZE(5, 30_000_000),
    FIRST_PRIZE(6, 2_000_000_000),
    NO_PRIZE(0, 0);

    private final int matchingNumbersCount;
    private final long prize;

    WinningRank(int matchingNumbersCount, long prize) {
        this.matchingNumbersCount = matchingNumbersCount;
        this.prize = prize;
    }

    public static WinningRank getWinningPrizeByResult(int matchingNumbersCount, boolean matchBonusNumber) {
        if (matchingNumbersCount == 5) {
            if (matchBonusNumber) {
                return SECOND_PRIZE;
            }
            return THIRD_PRIZE;
        }
        for (WinningRank prize : values()) {
            if (prize.matchingNumbersCount == matchingNumbersCount) {
                return prize;
            }
        }
        return NO_PRIZE;
    }

    public long getPrize() {
        return this.prize;
    }

    @Override
    public String toString() {
        if (this == SECOND_PRIZE) {
            return this.matchingNumbersCount + "개 일치, 보너스 볼 일치 " + "(" + formatPrize(this.prize) + ")";
        }
        return this.matchingNumbersCount + "개 일치 " + "(" + formatPrize(this.prize) + ")";
    }

    private String formatPrize(long prize) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###원");

        return decimalFormat.format(prize);
    }
}
