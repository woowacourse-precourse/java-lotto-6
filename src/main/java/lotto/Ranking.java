package lotto;

import java.text.DecimalFormat;

public enum Ranking {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NONE(0, false, 0);

    private final int matchingCount;
    private final boolean shouldMatchingBonusNumber;
    private final int prizeMoney;

    Ranking(final int matchingCount, final boolean shouldMatchingBonusNumber, final int prizeMoney) {
        this.matchingCount = matchingCount;
        this.shouldMatchingBonusNumber = shouldMatchingBonusNumber;
        this.prizeMoney = prizeMoney;
    }

    public static Ranking find(int count, boolean hasBonusNumber) {
        for (Ranking ranking : Ranking.values()) {
            if (ranking.isEqual(count, hasBonusNumber))
                return ranking;
        }
        return Ranking.NONE;
    }

    private boolean isEqual(int count, boolean hasBonusNumber) {
        if (count == 5)
            return this.matchingCount == count && this.shouldMatchingBonusNumber == hasBonusNumber;
        return this.matchingCount == count;
    }

    public String getResult(int time) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        String bonusMessage = "";
        if (shouldMatchingBonusNumber)
            bonusMessage = ", 보너스 볼 일치";
        return String.format("%d개 일치%s (%s원) - %d개", matchingCount, bonusMessage, formatter.format(prizeMoney), time);
    }
}
