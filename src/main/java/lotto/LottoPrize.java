package lotto;

public enum LottoPrize {
    NONE(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    private final int matchCount;
    private final int prizeMoney;
    private final boolean bonusMatch;

    LottoPrize(int matchCount, int prizeMoney, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.bonusMatch = bonusMatch;
    }

    public static LottoPrize valueOf(int matchCount, boolean bonusMatch) {
        if (matchCount == SECOND.matchCount && bonusMatch) {
            return SECOND;
        }

        for (LottoPrize prize : LottoPrize.values()) {
            if (prize.matchCount == matchCount) {
                return prize;
            }
        }
        return NONE;
    }

    public String getPrizeDescription() {
        if (this == SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원)", matchCount, formatPrizeMoney(prizeMoney));
        }
        return String.format("%d개 일치 (%s원)", matchCount, formatPrizeMoney(prizeMoney));
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    private String formatPrizeMoney(int prizeMoney) {
        return String.format("%,d", prizeMoney);
    }
}
