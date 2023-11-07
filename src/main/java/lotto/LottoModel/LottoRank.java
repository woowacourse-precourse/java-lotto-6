package lotto.LottoModel;

public enum LottoRank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE(0, 0, false);

    private final int matchCount;
    private final int prize;
    private final boolean matchBonus;

    LottoRank(int matchCount, int prize, boolean matchBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.matchBonus = matchBonus;
    }

    public static LottoRank rankCheck(int matchCount, boolean matchBonus) {
        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount && (matchBonus == rank.matchBonus)) {
                return rank;
            }
        }
        return NONE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}

