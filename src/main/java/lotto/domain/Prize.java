package lotto.domain;

public enum Prize {
    NONE(0, 0, false),
    THREE_MATCH(3, 5_000, false),
    FOUR_MATCH(4, 50_000, false),
    FIVE_MATCH(5, 1_500_000, false),
    FIVE_WITH_BONUS(5, 30_000_000, true),
    SIX_MATCH(6, 2_000_000_000, false);

    private final int matchCount;
    private final int prizeMoney;
    private final boolean bonusMatch;

    Prize(int matchCount, int prizeMoney, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.bonusMatch = bonusMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public static Prize valueOf(int matchCount, boolean hasBonus) {
        if (matchCount == FIVE_WITH_BONUS.getMatchCount() && hasBonus) {
            return FIVE_WITH_BONUS;
        }
        for (Prize prize : Prize.values()) {
            if (prize.getMatchCount() == matchCount && !prize.isBonusMatch()) {
                return prize;
            }
        }
        return NONE;
    }
}
