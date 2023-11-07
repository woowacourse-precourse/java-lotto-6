package lotto;

import java.util.Arrays;
import java.util.List;

public class WinningRankCountsDto {
    private final Integer countOfMatchingNumbers;
    private final boolean requiresBonus;
    private final long prize;
    private final Integer winningCount;

    private WinningRankCountsDto(Integer countOfMatchingNumbers, boolean requiresBonus, long prize, Integer winningCount) {
        this.countOfMatchingNumbers = countOfMatchingNumbers;
        this.requiresBonus = requiresBonus;
        this.prize = prize;
        this.winningCount = winningCount;
    }

    public static List<WinningRankCountsDto> from(final WinningRankCounts winningRankCounts) {
        return Arrays.stream(WinningRank.values())
                .filter(winningRank -> winningRank != WinningRank.NO_WIN)
                .map(winningRank -> {
                    int matchingNumbers = winningRank.getCountOfMatchingNumbers();
                    boolean requiresBonus = winningRank.isRequiresBonus();
                    long prize = winningRank.getPrize();
                    int count = winningRankCounts.getCount(winningRank);
                    return new WinningRankCountsDto(matchingNumbers, requiresBonus, prize, count);
                })
                .toList();
    }

    public Integer getCountOfMatchingNumbers() {
        return countOfMatchingNumbers;
    }

    public boolean isRequiresBonus() {
        return requiresBonus;
    }

    public long getPrize() {
        return prize;
    }

    public Integer getWinningCount() {
        return winningCount;
    }
}
