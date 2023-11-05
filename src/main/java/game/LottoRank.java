package game;

public enum LottoRank {
    FIRST_RANK(6, 2000000000),
    SECOND_RANK(5, 30000000),
    THIRD_RANK(5, 1500000),
    FOURTH_RANK(4, 50000),
    FIFTH_RANK(3, 5000),
    OTHER_RANK(0, 0);

    private final int matchCount;
    private final int reward;

    LottoRank(int matches, int reward) {
        this.matchCount = matches;
        this.reward = reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}