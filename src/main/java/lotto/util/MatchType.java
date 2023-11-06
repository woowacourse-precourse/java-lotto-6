package lotto.util;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

public enum MatchType {
    THREE(3, false, "5,000"),
    FOUR(4, false, "50,000"),
    FIVE(5, false, "1,500,000"),
    FIVE_BONUS(5, true, "30,000,000"),
    SIX(6, false, "2,000,000,000");

    private final int sameNumbersCount;
    private final boolean bonusNumberIncluded;
    private final String prizeMoney;

    MatchType(int sameNumbersCount, boolean bonusNumberIncluded, String prizeMoney) {
        this.sameNumbersCount = sameNumbersCount;
        this.bonusNumberIncluded = bonusNumberIncluded;
        this.prizeMoney = prizeMoney;
    }

    public static Optional<MatchType> valueOf(int sameNumbersCount, boolean bonusNumberIncluded) {
        return Arrays.stream(MatchType.values())
                .filter(matchType -> matchType.sameNumbersCount == sameNumbersCount
                        && matchType.bonusNumberIncluded == bonusNumberIncluded)
                .findFirst();
    }

    public static void printWinningStatistics(Map<MatchType, Integer> winningStatistics) {
        StringBuilder sb = new StringBuilder(UiVO.getWinningStatistics());
        for (MatchType matchType : MatchType.values()) {
            sb.append(String.format(UiVO.getMatchesFormat(),
                    matchType.sameNumbersCount,
                    matchType.prizeMoney,
                    winningStatistics.getOrDefault(matchType, 0)));
        }
        System.out.println(sb);
    }
}