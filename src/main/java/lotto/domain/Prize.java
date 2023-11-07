package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NONE(0, false, 0);

    private final int numberOfMatches;
    private final boolean bonusIncluded;
    private final long prizeMoney;

    Prize(int numberOfMatches, boolean bonusIncluded, long prizeMoney) {
        this.numberOfMatches = numberOfMatches;
        this.bonusIncluded = bonusIncluded;
        this.prizeMoney = prizeMoney;
    }

    public static Prize valueOf(int numberOfMatches, boolean bonusIncluded) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.isSamePrize(numberOfMatches, bonusIncluded))
                .findFirst()
                .orElse(NONE);
    }

    private boolean isSamePrize(int numberOfMatches, boolean bonusMatched) {
        return this.numberOfMatches == numberOfMatches && (!this.bonusIncluded || bonusMatched);
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public boolean isBonusIncluded() {
        return bonusIncluded;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}
