package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum WinningStatistics {

    FIRST(List.of(6L), false),
    SECOND(List.of(5L), true),
    THIRD(List.of(5L), false),
    FOUR(List.of(4L), false),
    FIFTH(List.of(3L), false),
    RETIER(List.of(0L, 1L, 2L), false),
    NONE(List.of(), false);


    private List<Long> winningTier;
    private boolean correctBonusFlag;

    WinningStatistics(List<Long> winningTier, boolean correctBonusFlag) {
        this.winningTier = winningTier;
        this.correctBonusFlag = correctBonusFlag;
    }

    public static WinningStatistics confirm(long correctWinningCount, boolean correctBonusCount) {
        WinningStatistics winningStatistics = Arrays.stream(WinningStatistics.values())
                .filter(statistics -> statistics.winningTier.contains(correctWinningCount))
                .filter(statistics -> statistics.correctBonusFlag == correctBonusCount)
                .findFirst()
                .orElse(NONE);

        return winningStatistics;
    }

}
