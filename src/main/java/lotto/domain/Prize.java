package lotto.domain;

import java.util.Arrays;

public enum Prize {

    NONE(0, 0, false),
    FIFTH(3, 5000, false),
    FOURTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000, false);

    private final int matchingNumbers;
    private final int prizeMoney;
    private final boolean bonusMatch;

    Prize(int matchingNumbers, int prizeMoney, boolean bonusMatch) {
        this.matchingNumbers = matchingNumbers;
        this.prizeMoney = prizeMoney;
        this.bonusMatch = bonusMatch;
    }

    public static Prize determinePrize(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            return SECOND;
        }
        return Arrays.stream(Prize.values())
                .filter(p -> p.matchingNumbers == matchCount && (!p.bonusMatch || bonusMatch == p.bonusMatch))
                .findFirst()
                .orElse(NONE);
    }


    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }
}
