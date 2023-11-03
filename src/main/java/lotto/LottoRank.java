package lotto;

public enum LottoRank {
    FIFTH(0, 3, 5000),
    FOURTH(1, 4, 50000),
    THIRD(2, 5, 1500000),
    SECOND(3, 5, 30000000),
    FIRST(4, 6, 2000000000);

    private final int index;
    private final int matchCount;
    private final int prize;

    LottoRank(int index, int matchCount, int prize){
        this.index = index;
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getIndex(){
        return index;
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
