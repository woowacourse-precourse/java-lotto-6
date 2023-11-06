package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6,false,2_000_000_000),
    SECOND(5,true,30_000_000),
    THIRD(5,false,1_500_000),
    FOURTH(4,false,50_000),
    FIFTH(3,false,5_000);

    private final int count;
    private final boolean bonus;
    private final int reward;

    Rank(int count,boolean bonus,int reward){
        this.count=count;
        this.bonus=bonus;
        this.reward=reward;
    }

    public int getCount(){
        return count;
    }

    public boolean getBonus(){
        return bonus;
    }

    public static Rank valueOfCount(int count,boolean bonus){
        return Arrays.stream(values())
                .filter(value->value.count==count && value.bonus==bonus)
                .findAny()
                .orElse(null);
    }


}
