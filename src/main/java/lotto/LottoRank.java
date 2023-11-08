package lotto;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(4, 1_500_000),
    FOURTH(3, 50_000),
    FIFTH(2, 5_000),
    NONE(0, 0);

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
    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}
