package lotto.domain;

import java.util.Collections;
import java.util.List;

public enum LottoPrize {
    FIRST(6, 2_000_000_000),
    SECOND(6, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private final int matchingNumbers;
    private final long prize;

    LottoPrize(int matchingNumbers, int prize) {
        this.matchingNumbers = matchingNumbers;
        this.prize = prize;
    }

    public static LottoPrize determinePrize(int matchedNumbers, boolean bonusNumberMatch) {
        if (matchedNumbers == Lotto.MAX_NUMBERS) {
            return determineSixMatchPrize(bonusNumberMatch);
        }
        return determineOtherMatchesPrize(matchedNumbers);
    }

    private static LottoPrize determineSixMatchPrize(boolean bonusNumberMatch) {
        if (bonusNumberMatch) {
            return SECOND;
        }
        return FIRST;
    }

    private static LottoPrize determineOtherMatchesPrize(int matchedNumbers) {
        for (LottoPrize prize : values()) {
            if (prize.matchingNumbers == matchedNumbers) {
                return prize;
            }
        }
        return null;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public long getPrize() {
        return prize;
    }

    public static List<LottoPrize> getReverseLottoPrize() {
        LottoPrize[] values = LottoPrize.values();
        List<LottoPrize> reversedLottoPrize = new java.util.ArrayList<>(List.of(values));
        Collections.reverse(reversedLottoPrize);
        return reversedLottoPrize;
    }
}
