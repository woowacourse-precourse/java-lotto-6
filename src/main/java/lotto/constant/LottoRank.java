package lotto.constant;

public enum LottoRank {
    RANK_ONE(6, 0, 2000000000),
    RANK_TWO(5, 1, 30000000),
    RANK_THREE(5, 0, 1500000),
    RANK_FOUR(4, 0, 50000),
    RANK_FIVE(3, 0, 5000),
    RANK_OUTSIDE(0, 0, 0);

    private final int matchedNormalNum;
    private final int matchedBonusNum;
    private final int reward;

    LottoRank(int matchedNormalNum, int matchedBonusNum, int reward) {
        this.matchedNormalNum = matchedNormalNum;
        this.matchedBonusNum = matchedBonusNum;
        this.reward = reward;
    }

    public int getMatchedNormalNum() {
        return matchedNormalNum;
    }

    public int getMatchedBonusNum() {
        return matchedBonusNum;
    }

    public int getReward() {
        return reward;
    }
}
