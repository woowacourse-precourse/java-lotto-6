package lotto.domain;

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
        if (validateMatchingNumbers(matchingNumbers)) {
            throw new IllegalArgumentException();
        }

        if (matchingNumbers == 5 && hasBonusNumber) {
            return SECOND.prizeAmount;
        }

        for (WinningPrize prize : WinningPrize.values()) {
            if (prize.matchingNumbers == matchingNumbers && hasBonusNumber) {
                return prize.prizeAmount;
            }
        }

        return 0;
    }

    private static boolean validateMatchingNumbers(Integer matchingNumbers) {
        return matchingNumbers < 3 || matchingNumbers > 6;
    }
}
