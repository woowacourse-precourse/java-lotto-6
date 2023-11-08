package lotto;

public enum Rank {
    FIRST(6,0,2000000000),
    SECOND(5,1,30000000),
    THIRD(5,0,1500000),
    FOURTH(4,0,50000),
    FIFTH(3,0,5000),
    NOTHING(0,0,0);

    private int matchWinningCount;
    private int matchBonusCount;
    private int prizeMoney;

    Rank(int matchWinningCount, int matchBonusCount, int prizeMoney) {
        this.matchWinningCount = matchWinningCount;
        this.matchBonusCount=matchBonusCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchWinningCount(){
        return matchWinningCount;
    }

    public int getPrizeMoney(){
        return prizeMoney;
    }

    public int getMatchBonusCount(){
        return matchBonusCount;
    }

}
