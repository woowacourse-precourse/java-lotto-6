package lotto;

public enum Rank {
    NOTHING(0,0,0),
    FIFTH(3,0,5000),
    FOURTH(4,0,50000),
    THIRD(5,0,1500000),
    SECOND(5,1,30000000),
    FIRST(6,0,2000000000);

    private int matchWinningCount;
    private int matchBonusCount;
    private int prizeMoney;

    Rank(int matchWinningCount, int matchBonusCount, int prizeMoney) {
        this.matchWinningCount = matchWinningCount;
        this.matchBonusCount=matchBonusCount;
        this.prizeMoney = prizeMoney;
    }

    public static Rank calculateRank(int matchWinningCount, int matchBonusCount) {
        for (Rank rank : values()) {
            if (rank.matchWinningCount == matchWinningCount && rank.matchBonusCount == matchBonusCount) {
                return rank;
            }
        }
        return NOTHING;
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
