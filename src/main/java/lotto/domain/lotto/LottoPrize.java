package lotto.domain.lotto;

import java.util.Arrays;

public enum LottoPrize {
    LOSE(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(4, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    private final int matchCount;
    private final int prizeAmount;
    private final boolean isBonusMatched;

    LottoPrize(int matchCount, int prizeAmount, boolean isBonusMatched) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
        this.isBonusMatched = isBonusMatched;
    }

    public int matchCount() {
        return matchCount;
    }

    public int prizeAmount() {
        return prizeAmount;
    }

    public boolean isBonusMatched() {
        return isBonusMatched;
    }

    public static LottoPrize findLottoPrize(int matchingNumbers, boolean isBonusMatched) {
        return Arrays.stream(values())
            .filter(prize -> prize.matchCount() == matchingNumbers
                && prize.isBonusMatched() == isBonusMatched)
            .findFirst()
            .orElse(LOSE);
    }
}