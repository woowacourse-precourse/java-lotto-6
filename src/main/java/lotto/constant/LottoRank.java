package lotto.constant;

public enum LottoRank {
    RANK_ONE(6, 0),
    RANK_TWO(5, 1),
    RANK_THREE(5, 0),
    RANK_FOUR(4, 0),
    RANK_FIVE(3, 0);

    private final int matchedNormalNum;
    private final int matchedBonusNum;

    LottoRank(int matchedNormalNum, int matchedBonusNum) {
        this.matchedNormalNum = matchedNormalNum;
        this.matchedBonusNum = matchedBonusNum;
    }

    public int getMatchedNormalNum() {
        return matchedNormalNum;
    }

    public int getMatchedBonusNum() {
        return matchedBonusNum;
    }
}
