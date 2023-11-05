package lotto.domain.enums;

import java.util.Arrays;

public enum LottoPrize {
    LOSE(0, 0, false),
    FIFTH(3, 5000, false),
    FOURTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(4, 30000000, true),
    FIRST(6, 2000000000, false);

    private final int matchCount;
    private final int prizeAmount;
    private final boolean isBonusMatched;

    LottoPrize(int matchCount, int prizeAmount, boolean isBonusMatched) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
        this.isBonusMatched = isBonusMatched;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public boolean isBonusMatched() {
        return isBonusMatched;
    }

    public static LottoPrize findLottoPrize(int matchingNumbers, boolean isBonusMatched) {
        return Arrays.stream(values())
            .filter(prize -> prize.getMatchCount() == matchingNumbers
                && prize.isBonusMatched() == isBonusMatched)
            .findFirst()
            .orElse(LOSE);
    }
}