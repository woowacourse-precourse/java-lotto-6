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

    public static LottoPrize of(int matchingNumbers, boolean isBonusNumberMatched) {
        if (isEligibleForSecondPrize(matchingNumbers, isBonusNumberMatched)) {
            return SECOND_PRIZE;
        }

        return findByMatchingNumbers(matchingNumbers);
    }

    private static boolean isEligibleForSecondPrize(int matchingNumbers, boolean isBonusNumberMatched) {
        return matchingNumbers == SECOND_PRIZE.requiredMatchingNumbers && isBonusNumberMatched;
    }

    private static LottoPrize findByMatchingNumbers(int matchingNumbers) {
        return Stream.of(values())
                .filter(prize -> isMatchingNumbers(prize, matchingNumbers))
                .findFirst()
                .orElse(NOTHING);
    }

    private static boolean isMatchingNumbers(LottoPrize prize, int matchingNumbers) {
        return prize.requiredMatchingNumbers == matchingNumbers;
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
