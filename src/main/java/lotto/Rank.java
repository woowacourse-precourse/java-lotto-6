package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6,false,2000000000),
    SECOND(5,true,30000000),
    THIRD(5,false,1500000),
    FOURTH(4,false,50000),
    FIFTH(3,false,5000);

    private final int matchCount;
    private final boolean isMatchBonusNumber;
    private final long reward;

    Rank(int matchCount, boolean isMatchBonusNumber, long reward){
        this.matchCount=matchCount;
        this.isMatchBonusNumber=isMatchBonusNumber;
        this.reward=reward;
    }

    public static Rank getRank(int matchCount,boolean isMatchBonusNumber){
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isSameMatchCount(matchCount) && rank.isSameMatchBounsNumber(isMatchBonusNumber))
                .findFirst().orElse(null);
    }

    private boolean isSameMatchCount(int matchCount){
        return matchCount==this.matchCount;
    }

    private boolean isSameMatchBounsNumber(boolean isMatchBonusNumber){
        return isMatchBonusNumber==this.isMatchBonusNumber;
    }


}
