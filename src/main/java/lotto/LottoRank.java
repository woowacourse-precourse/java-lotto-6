package lotto;

public enum LottoRank {
    NONE(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    private final int matchCount;
    private final int prizeMoney;
    private final boolean matchBonus;

    LottoRank(int matchCount, int prizeMoney, boolean matchBonus) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.matchBonus = matchBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public static LottoRank valueOf(int matchCount, boolean matchBonus) {
        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount && (rank.matchBonus == matchBonus || !rank.matchBonus)) {
                return rank;
            }
        }
        return NONE;
    }
}
