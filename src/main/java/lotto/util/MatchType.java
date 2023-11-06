package lotto.util;

import java.util.Arrays;
import java.util.Optional;

public enum MatchType {
    THREE(3, false, 5000),
    FOUR(4, false, 50000),
    FIVE(5, false, 1500000),
    FIVE_BONUS(5, true, 30000000),
    SIX(6, false, 2000000000);

    private final int sameNumbersCount;
    private final boolean bonusNumberIncluded;
    private final int prizeMoney;

    MatchType(int sameNumbersCount, boolean bonusNumberIncluded, int prizeMoney) {
        this.sameNumbersCount = sameNumbersCount;
        this.bonusNumberIncluded = bonusNumberIncluded;
        this.prizeMoney = prizeMoney;
    }

    public int getSameNumbersCount() {
        return sameNumbersCount;
    }

    public boolean isBonusNumberIncluded() {
        return bonusNumberIncluded;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Optional<MatchType> valueOf(int sameNumbersCount, boolean bonusNumberIncluded) {
        return Arrays.stream(MatchType.values())
                .filter(matchType -> matchType.sameNumbersCount == sameNumbersCount
                        && matchType.bonusNumberIncluded == bonusNumberIncluded)
                .findFirst();
    }
}