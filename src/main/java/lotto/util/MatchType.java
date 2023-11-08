package lotto.util;

import java.util.Arrays;
import java.util.Optional;

public enum MatchType {
    THREE(3, false, 5_000, "%s개 일치 (%,d원) - %d개\n"),
    FOUR(4, false, 50_000, "%s개 일치 (%,d원) - %d개\n"),
    FIVE(5, false, 1_500_000, "%s개 일치 (%,d원) - %d개\n"),
    FIVE_BONUS(5, true, 30_000_000, "%s개 일치, 보너스 볼 일치 (%,d원) - %d개\n"),
    SIX(6, false, 2_000_000_000, "%s개 일치 (%,d원) - %d개\n");

    private final int sameNumbersCount;
    private final boolean bonusNumberIncluded;
    private final int prizeMoney;
    private final String printFormat;

    MatchType(int sameNumbersCount, boolean bonusNumberIncluded, int prizeMoney, String printFormat) {
        this.sameNumbersCount = sameNumbersCount;
        this.bonusNumberIncluded = bonusNumberIncluded;
        this.prizeMoney = prizeMoney;
        this.printFormat = printFormat;
    }

    public int getSameNumbersCount() {
        return sameNumbersCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getPrintFormat() {
        return this.printFormat;
    }

    public static Optional<MatchType> valueOf(int sameNumbersCount, boolean bonusNumberIncluded) {
        return Arrays.stream(MatchType.values())
                .filter(matchType -> matchType.sameNumbersCount == sameNumbersCount
                        && matchType.bonusNumberIncluded == bonusNumberIncluded)
                .findFirst();
    }
}