package lotto;

public enum Prize {
    FIRST(6,0,2_000_000_000),
    SECOND(5,1,30_000_000),
    THIRD(5,0,1_500_000),
    FOURTH(4,0,50_000),
    FIFTH(3,0,5_000),
    NONE(0,0,0);

    private final int matchCount;
    private final int bonusCount;
    private final int prizeMoney;

    Prize(int matchCount, int bonusCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.bonusCount = bonusCount;
        this.prizeMoney = prizeMoney;
    }

    public boolean matches(int matchCount, int bonusCount) {
        return this.matchCount == matchCount && this.bonusCount == bonusCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Prize determinePrize(int matchCount, int bonusCount) {
        for (Prize prize : values()) {
            if (prize.matches(matchCount, bonusCount)) {
                return prize;
            }
        }
        return NONE;
    }
}
