package lotto;

public enum LottoRank {
    NONE(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int matchCount;
    private final int reward;

    LottoRank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static LottoRank fromMatchCount(int matchCount) {
        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount) {
                return rank;
            }
        }
        return NONE;
    }
    public static LottoRank valueOf(int matchCount, boolean hasBonus) {

        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && hasBonus) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return NONE;
    }
    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

}
