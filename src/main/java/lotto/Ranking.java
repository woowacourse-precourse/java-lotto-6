package lotto;

public enum Ranking {
    ZERO(0,0),
    ONE(1,0),
    TWO(2, 0),
    THREE(3,5000),
    FOUR(4,50_000),
    FIVE(5,1_500_000),
    SIX(6,2_000_000_000),
    FIVE_AND_BONUS(7,30_000_000);

    private final int rankingValue;
    private final int lottoNum;
    Ranking(int lottoNum, int rankingValue) {
        this.lottoNum = lottoNum;
        this.rankingValue = rankingValue;
    }

    public int getLottoNum() {
        return lottoNum;
    }

    public  int getRankingValue() {
        return rankingValue;
    }
}
