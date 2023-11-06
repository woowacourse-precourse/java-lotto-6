package lotto.domain;

import java.util.Arrays;
import java.util.EnumSet;

public enum WinningStatistic {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private final Integer matchingNumbers;
    private final Integer prizeAmount;

    WinningStatistic(Integer matchingNumbers, Integer prizeAmount) {
        this.matchingNumbers = matchingNumbers;
        this.prizeAmount = prizeAmount;
    }

    public static WinningStatistic getRankTypeByMatchNumbers(Integer matchingNumbers, boolean hasBonusNumber) {
        if (matchingNumbers == 5 && hasBonusNumber) {
            return SECOND;
        }

        return EnumSet.range(FIRST, FIFTH).stream()
                .filter(prize -> prize.matchingNumbers.equals(matchingNumbers))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static Integer calculatePrize(Integer matchingNumbers, boolean hasBonusNumber) {

        if (matchingNumbers == 5 && hasBonusNumber) {
            return SECOND.prizeAmount;
        }

        return Arrays.stream(WinningStatistic.values())
                .filter(prize -> prize.matchingNumbers.equals(matchingNumbers))
                .findFirst()
                .map(prize -> prize.prizeAmount)
                .orElseThrow(IllegalArgumentException::new);
    }
}
