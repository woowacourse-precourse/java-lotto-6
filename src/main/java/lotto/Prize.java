package lotto;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prizeMoney;

    Prize(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Prize determinePrize(int matchCount, boolean isBonus) {
        if (matchCount == 5 && isBonus) {
            return SECOND;
        }
        for (Prize prize : Prize.values()) {
            if (prize.getMatchCount() == matchCount) {
                return prize;
            }
        }
        return NONE;
    }

    public String getFormattedPrizeName() {
        if (this == FIRST) return "6개 일치";
        if (this == SECOND) return "5개 일치, 보너스 볼 일치";
        if (this == THIRD) return "5개 일치";
        if (this == FOURTH) return "4개 일치";
        if (this == FIFTH) return "3개 일치";
        return "";
    }
}
