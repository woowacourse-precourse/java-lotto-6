package lotto;

import java.text.NumberFormat;
import java.util.Locale;

public enum PrizeTier {
    NONE(0, false, 0, "꽝"),
    FIFTH(3, false, 5_000, "3개 일치"),
    FOURTH(4, false, 50_000, "4개 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, false, 2_000_000_000, "6개 일치");

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prizeMoney;
    private final String tierName;
    private static final NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);

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
        String prizeMoneyFormatted = numberFormat.format(this.prizeMoney);
        return tierName + " (" + prizeMoneyFormatted + "원)";
    }
}
