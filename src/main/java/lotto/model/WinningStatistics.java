package lotto.model;

import java.util.Arrays;

public enum WinningStatistics {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_MATCH_BONUS(5, 30000000),
    SIX_MATCH(6, 2000000000),
    MISS_MATCH(0, 0);

    private final int matchingCount;
    private final int prizeMoney;

    WinningStatistics(int matchingCount, int prizeMoney) {
        this.matchingCount = matchingCount;
        this.prizeMoney = prizeMoney;
    }

    public static WinningStatistics getStatistic(int matchingCount, boolean containBonusBall) {
        if (matchingCount == FIVE_MATCH_BONUS.matchingCount && containBonusBall) {
            return FIVE_MATCH_BONUS;
        }

        if (matchingCount < 3) {
            return MISS_MATCH;
        }

        return Arrays.stream(values())
                .filter(statistics -> statistics.matchingCount == matchingCount)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 답이 없습니다."));
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
