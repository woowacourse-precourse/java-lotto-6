package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum WinningPrize {
    FIRST_PRIZE(6, 2_000_000_000),
    SECOND_PRIZE(5, 30_000_000),
    THIRD_PRIZE(5, 1_500_000),
    FOURTH_PRIZE(4, 50_000),
    FIFTH_PRIZE(3, 5_000),
    EMPTY_PRIZE(0, 0);

    private static final int MIN_WINNING_COUNT = 3;

    private final int winningNumbersCount;
    private final int winningPrizeAmount;

    WinningPrize(int winningNumbersCount, int winningPrizeAmount) {
        this.winningNumbersCount = winningNumbersCount;
        this.winningPrizeAmount = winningPrizeAmount;
    }

    public int getWinningPrizeAmount() {
        return winningPrizeAmount;
    }

    public static WinningPrize valueOf(int winningNumbersCount, boolean existBonusNumber) {
        if (winningNumbersCount < MIN_WINNING_COUNT) {
            return EMPTY_PRIZE;
        }
        WinningPrize winningPrize = WinningPrize.valueOf(winningNumbersCount);
        if (isThirdPrize(existBonusNumber, winningPrize)) {
            return THIRD_PRIZE;
        }

        return winningPrize;
    }

    private static boolean isThirdPrize(boolean existBonusNumber, WinningPrize winningPrize) {
        return winningPrize == SECOND_PRIZE && !existBonusNumber;
    }

    private static WinningPrize valueOf(int winningNumbersCount) {
        return Arrays.stream(WinningPrize.values())
                .filter(WinningPrize -> WinningPrize.winningNumbersCount == winningNumbersCount)
                .findFirst()
                .orElse(EMPTY_PRIZE);
    }
}
