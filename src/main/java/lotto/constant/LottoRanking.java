package lotto.constant;

public enum LottoRanking {
    FIRST(6, false, 2000000000, "6개 일치"),
    SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, false, 1500000, "5개 일치"),
    FOURTH(4, false, 50000, "4개 일치"),
    FIFTH(3, false, 5000, "3개 일치"),
    OUT_OF_RANK(0, false, 0, "순위 밖");

    private final int matchCount;
    private final boolean hasBonus;
    private final int prize;
    private final String description;

    LottoRanking(int matchCount, boolean hasBonus, int prize, String description) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prize = prize;
        this.description = description;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isHasBonus() {
        return hasBonus;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }

    public static LottoRanking findRanking(int matchCount, boolean hasBonus) {
        for (LottoRanking rank : LottoRanking.values()) {
            if (rank.getMatchCount() == matchCount && rank.isHasBonus() == hasBonus) {
                return rank;
            }
        }
        for (LottoRanking rank : LottoRanking.values()) {
            if (rank.getMatchCount() == matchCount) {
                return rank;
            }
        }
        return LottoRanking.OUT_OF_RANK;
    }
}
