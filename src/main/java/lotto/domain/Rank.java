package lotto.domain;

import java.util.EnumSet;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final Integer matchingNumbers;
    private final Integer prizeAmount;

    Rank(Integer matchingNumbers, Integer prizeAmount) {
        this.matchingNumbers = matchingNumbers;
        this.prizeAmount = prizeAmount;
    }

    public static Rank getRankByMatchingNumbersAndBonus(Integer matchingNumbers, boolean isBonusNumberMatch) {
        if (matchingNumbers == 5 && isBonusNumberMatch) {
            return SECOND;
        }

        return EnumSet.range(FIRST, FIFTH).stream()
                .filter(prize -> prize.matchingNumbers.equals(matchingNumbers))
                .findFirst()
                .orElse(Rank.NONE);
    }

    public Integer getMatchingNumbers() {
        return matchingNumbers;
    }

    public Integer getPrizeAmount() {
        return prizeAmount;
    }
}
