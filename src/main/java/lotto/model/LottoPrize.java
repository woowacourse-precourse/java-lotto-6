package lotto.model;

import java.util.stream.Stream;

public enum LottoPrize {
    NOTHING(0, 0),
    FIFTH_PRIZE(3, 5_000),
    FOURTH_PRIZE(4, 50_000),
    THIRD_PRIZE(5, 1_500_000),
    SECOND_PRIZE(5, 30_000_000, true),
    FIRST_PRIZE(6, 2_000_000_000);

    public static final int ZERO_AMOUNT = 0;

    private final int requiredMatchingNumbers;
    private final int prizeMoney;
    private final boolean isBonusNumberRequired;

    LottoPrize(int requiredMatchingNumbers, int prizeMoney) {
        this(requiredMatchingNumbers, prizeMoney, false);
    }

    LottoPrize(int requiredMatchingNumbers, int prizeMoney, boolean isBonusNumberRequired) {
        this.requiredMatchingNumbers = requiredMatchingNumbers;
        this.prizeMoney = prizeMoney;
        this.isBonusNumberRequired = isBonusNumberRequired;
    }

    public static LottoPrize of(int numberOfMatches, boolean isBonusNumberRequired) {
        if (isEligibleForSecondPrize(numberOfMatches, isBonusNumberRequired)) {
            return SECOND_PRIZE;
        }

        return findByMatchingNumbers(numberOfMatches);
    }

    private static boolean isEligibleForSecondPrize(int numberOfMatches, boolean isBonusNumberRequired) {
        return numberOfMatches == SECOND_PRIZE.requiredMatchingNumbers && isBonusNumberRequired;
    }

    private static LottoPrize findByMatchingNumbers(int matchCount) {
        return Stream.of(values())
                .filter(prize -> isMatchingNumbers(prize, matchCount))
                .findFirst()
                .orElse(NOTHING);
    }

    private static boolean isMatchingNumbers(LottoPrize prize, int matchCount) {
        return prize.requiredMatchingNumbers == matchCount;
    }

    public long calculatePrizeAmount(Long prizeCount) {
        if (prizeCount == null) {
            return ZERO_AMOUNT;
        }

        return prizeMoney * prizeCount;
    }

    public boolean isSecondPrize() {
        return this == SECOND_PRIZE;
    }

    public boolean isWinningPrize() {
        return this != NOTHING;
    }

    public int getRequiredMatchingNumbers() {
        return requiredMatchingNumbers;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
