package lotto;

public enum Prize {
    FIRST(6,false,2000000000),
    SECOND(5,true,30000000),
    THIRD(5,false,1500000),
    FOURTH(4,false,50000),
    FIFTH(3,false,5000);

    private int matchCount;
    private boolean isMatchBonusNumber;
    private long reward;

    Prize(int matchCount,boolean isMatchBonusNumber,long reward){
        this.matchCount=matchCount;
        this.isMatchBonusNumber=isMatchBonusNumber;
        this.reward=reward;
    }
}
