package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum WinningStatistics {

    FIRST(List.of(6L), false, 1),
    SECOND(List.of(5L), true, 2),
    THIRD(List.of(5L), false, 3),
    FOUR(List.of(4L), false, 4),
    FIFTH(List.of(3L), false, 5),
    RETIER(List.of(0L, 1L, 2L), false, 6),
    NONE(List.of(), false, 0);


    private List<Long> winningTier;
    private boolean correctBonusFlag;
    private int rank;

    WinningStatistics(List<Long> winningTier, boolean correctBonusFlag, int rank) {
        this.winningTier = winningTier;
        this.correctBonusFlag = correctBonusFlag;
        this.rank = rank;
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
