package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum WinningStatistics {

    FIRST(List.of(6L), false, 1, 2000000000),
    SECOND(List.of(5L), true, 2, 30000000),
    THIRD(List.of(5L), false, 3, 1500000),
    FOUR(List.of(4L), false, 4, 50000),
    FIFTH(List.of(3L), false, 5, 5000),
    RETIER(List.of(0L, 1L, 2L), false, 6, 0),
    NONE(List.of(), false, 0, 0);


    private List<Long> winningTier;
    private boolean correctBonusFlag;
    private int rank;
    private int winningPrice;

    WinningStatistics(List<Long> winningTier, boolean correctBonusFlag, int rank, int winningPrice) {
        this.winningTier = winningTier;
        this.correctBonusFlag = correctBonusFlag;
        this.rank = rank;
        this.winningPrice = winningPrice;
    }

    public static WinningStatistics confirm(long correctWinningCount, boolean correctBonusCount) {
        WinningStatistics winningStatistics = Arrays.stream(WinningStatistics.values())
                .filter(statistics -> statistics.isContainsWinningTier(correctWinningCount))
                .filter(statistics -> statistics.isSameCorrectBonusFlag(correctBonusCount))
                .findFirst()
                .orElse(NONE);

        return winningStatistics;
    }

    private boolean isContainsWinningTier(long correctWinningCount) {
        return this.winningTier.contains(correctWinningCount);
    }

    private boolean isSameCorrectBonusFlag(boolean correctBonusCount) {
        return this.correctBonusFlag == correctBonusCount;
    }

    public int getRank() {
        return this.rank;
    }
}
