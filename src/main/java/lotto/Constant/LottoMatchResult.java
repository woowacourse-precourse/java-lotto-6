package lotto.Constant;

public enum LottoMatchResult {
    MATCH_THREE(3,5000),
    MATCH_FOUR(4,50000),
    MATCH_FIVE(5,1500000),
    MATCH_FIVE_WITH_BONUS(7,30000000),
    MATCH_SIX(6,2000000000);

    private final int matchCount;

    private final int lottoReward;

    LottoMatchResult(int matchCount, int lottoReward){
        this.matchCount = matchCount;
        this.lottoReward = lottoReward;
    }

    public int getMatchCount(){
        return matchCount;
    }

    public int getLottoReward(){
        return lottoReward;
    }

}
