package lotto;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int matchCount;
    private final int prize;

    LottoRank(int matchCount, int prize){
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount(){
        return matchCount;
    }

    public int getPrize(){
        return prize;
    }

    public static LottoRank calculateRank(int matchCount, boolean matchBonusNumber){
        if(matchCount == 6){
            return FIRST;
        }
        if(matchCount == 5 && matchBonusNumber == true){
            return SECOND;
        }
        if(matchCount == 5 && matchBonusNumber == false){
            return THIRD;
        }
        if(matchCount == 4){
            return FOURTH;
        }
        if(matchCount == 3){
            return FIFTH;
        }
        return null;
    }
}
