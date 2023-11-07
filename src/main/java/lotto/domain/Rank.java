package lotto.domain;

public enum Rank {

    FIRST(6, 2000000000),
    SECOND(5,30000000),
    THRID(5,1500000),
    FOURTH(4,50000),
    FIFTH(3,5000),
    NOTHING(0,0);

    private static final int MIN_MATCH_COUNT=3;
    private static final String ERROR_MESSAGE="[ERROR]";

    private int matchCount;
    private int winningMoney;

    public static Rank valueOf(int matchNum, boolean matchBonus){
        if(matchNum<MIN_MATCH_COUNT){
            return NOTHING;
        }

        if(SECOND.match(matchNum) && matchBonus){
            return SECOND;
        }

        for(Rank rank : values()){
            if(rank.match(matchNum)){
                return rank;
            }
        }

        throw new IllegalArgumentException(ERROR_MESSAGE);
    }

    Rank(int matchCount, int winningMoney)
    {
        this.matchCount=matchCount;
        this.winningMoney= winningMoney;
    }

    public int getMatchCount(){
        return matchCount;
    }

    public int getWinningMoney(){
        return winningMoney;
    }

    private boolean match(int countOfMatch){
        return matchCount ==countOfMatch;
    }


}
