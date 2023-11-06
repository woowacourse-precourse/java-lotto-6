package lotto;

import java.util.Arrays;

public enum PrizeTier {
    FIRST(6, false, 2_000_000, "1등"),
    SECOND(5, true, 30_000_000, "2등"),
    THIRD(5, false, 1_500_000, "3등"),
    FOURTH(4, false, 50_000, "4등"),
    FIFTH(3, false, 5_000, "5등"),
    NONE(0, false, 0, "No win");

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prizeMoney;
    private final String tierName;

    PrizeTier(int matchCount, boolean bonusMatch, int prizeMoney, String tierName) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prizeMoney = prizeMoney;
        this.tierName = tierName;
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }

    public static PrizeTier getPrizeTier(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            return SECOND;
        }
        for (PrizeTier prizeTier : PrizeTier.values()) {
            if (prizeTier.matchCount == matchCount && (prizeTier.bonusMatch == bonusMatch || !prizeTier.bonusMatch)) {
                return prizeTier;
            }
        }
        return NONE;
    }

    @Override
    public String toString() {
        return tierName + " - " + prizeMoney + "원";
    }
}
