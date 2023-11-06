package lotto.util;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

public enum MatchType {
    THREE(3, false, "5,000"),
    FOUR(4, false, "50,000"),
    FIVE(5, false, "1,500,000"),
    FIVE_BONUS(5, true, "30,000,000"),
    SIX(6, false, "2,000,000,000");

    private final int sameNumbersCount;
    private final boolean bonusNumberIncluded;
    private final String prizeMoney;

    MatchType(int sameNumbersCount, boolean bonusNumberIncluded, String prizeMoney) {
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

    public String getPrizeMoney() {
        return prizeMoney;
    }

    public static Optional<MatchType> valueOf(int sameNumbersCount, boolean bonusNumberIncluded) {
        return Arrays.stream(MatchType.values())
                .filter(matchType -> matchType.sameNumbersCount == sameNumbersCount
                        && matchType.bonusNumberIncluded == bonusNumberIncluded)
                .findFirst();
    }
}