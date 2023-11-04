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
    private final boolean requiresBonusNumber;

    LottoPrize(int requiredMatchingNumbers, int prizeMoney) {
        this(requiredMatchingNumbers, prizeMoney, false);
    }

    LottoPrize(int requiredMatchingNumbers, int prizeMoney, boolean requiresBonusNumber) {
        this.requiredMatchingNumbers = requiredMatchingNumbers;
        this.prizeMoney = prizeMoney;
        this.requiresBonusNumber = requiresBonusNumber;
    }

    public static LottoPrize of(int numberOfMatches, boolean isBonusNumberMatched) {
        if (isEligibleForSecondPrize(numberOfMatches, isBonusNumberMatched)) {
            return SECOND_PRIZE;
        }
        return findByMatchingNumbers(numberOfMatches);
    }

    private static boolean isEligibleForSecondPrize(int numberOfMatches, boolean isBonusNumberMatched) {
        return numberOfMatches == SECOND_PRIZE.requiredMatchingNumbers && isBonusNumberMatched;
    }

    private static LottoPrize findByMatchingNumbers(int matchCount) {
        return Stream.of(values())
                .filter(prize -> prize.requiredMatchingNumbers == matchCount)
                .findFirst()
                .orElse(NOTHING);
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
