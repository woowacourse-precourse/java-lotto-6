package lotto.domain;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NOTHING(0,false,0)
    ;

    private final int matchCount;
    private final boolean matchBonus;
    private final long prizeMoney;

    Rank(int matchCount, boolean matchBonus, long prizeMoney){
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prizeMoney = prizeMoney;
    }

    //public static Rank findRank(int count, boolean hasBonus){
    //    return ;
    //}

    public int getMatchCount(){
        return matchCount;
    }
    public long getPrizeMoney(){
        return prizeMoney;
    }
}
