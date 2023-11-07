package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Rank {
    ZERO(0,0),
    FIRST(6,2000000000),
    SECOND_BONUS(5,30000000),
    SECOND(5,1500000),
    THIRD(4,50000),
    FOURTH(3,5000);
    final private int count;
    final private long money;

    Rank(int count, long money) {
        this.count = count;
        this.money = money;
    }
    public static Rank getRankByCount(int count) {
        Rank[] ranks = values();
        for(Rank rank : ranks){
            if(rank.count == count){
                return rank;
            }
        }
        return Rank.ZERO;
    }

    public int getCount() {
        return count;
    }

    public long getMoney() {
        return money;
    }

}
