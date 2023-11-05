package Utils;

public enum LottoRank {

    FIRST(6, 2_000_000_000, false, Messages.SIX_MATCHES),
    SECOND(5, 30_000_000, true, Messages.FIVE_BONUS_MATCHES),
    THIRD(5, 1_500_000, false, Messages.FIVE_MATCHES),
    FOURTH(4, 50_000, false, Messages.FOUR_MATCHES),
    FIFTH(3, 5_000, false, Messages.THREE_MATCHES),
    NONE(0, 0, false, "");

    private final int matchCount;
    private final int prizeMoney;
    private final boolean bonusMatch;
    private final String description;

    LottoRank(int matchCount, int prizeMoney, boolean bonusMatch, String description) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.bonusMatch = bonusMatch;
        this.description = description;
    }

    public String getDescription() {
        return description;
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

    public static LottoRank valueOf(int matchCount, boolean bonusMatch) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank.getMatchCount() == matchCount && (!rank.isBonusMatch() || bonusMatch)) {
                return rank;
            }
        }
        return NONE;
    }
}

