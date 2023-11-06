package lotto.domain;

import java.util.Arrays;

public enum WinningPrize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private final Integer matchingNumbers;
    private final Integer prizeAmount;

    WinningPrize(Integer matchingNumbers, Integer prizeAmount) {
        this.matchingNumbers = matchingNumbers;
        this.prizeAmount = prizeAmount;
    }

    public static Integer calculatePrize(Integer matchingNumbers, boolean hasBonusNumber) {

        if (matchingNumbers == 5 && hasBonusNumber) {
            return SECOND.prizeAmount;
        }

        return Arrays.stream(WinningPrize.values())
                .filter(prize -> prize.matchingNumbers.equals(matchingNumbers))
                .findFirst()
                .map(prize -> prize.prizeAmount)
                .orElseThrow(IllegalArgumentException::new);
    }
}
