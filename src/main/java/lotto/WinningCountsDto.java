package lotto;

import java.util.Arrays;
import java.util.List;

public class WinningCountsDto {
    private final Integer countOfMatchingNumbers;
    private final long prize;
    private final Integer winningCount;

    private WinningCountsDto(Integer countOfMatchingNumbers, long prize, Integer winningCount) {
        this.countOfMatchingNumbers = countOfMatchingNumbers;
        this.prize = prize;
        this.winningCount = winningCount;
    }

    public static List<WinningCountsDto> from(final WinningCounts winningCounts) {
        return Arrays.stream(WinningRank.values())
                .filter(winningRank -> winningRank != WinningRank.NO_WIN)
                .map(winningRank -> {
                    int matchingNumbers = winningRank.getCountOfMatchingNumbers();
                    long prize = winningRank.getPrize();
                    int count = winningCounts.getCount(winningRank);
                    return new WinningCountsDto(matchingNumbers, prize, count);
                })
                .toList();
    }

    public Integer getCountOfMatchingNumbers() {
        return countOfMatchingNumbers;
    }

    public long getPrize() {
        return prize;
    }

    public Integer getWinningCount() {
        return winningCount;
    }
}
