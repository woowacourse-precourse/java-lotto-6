package lotto;

import java.util.Arrays;
import java.util.Objects;

public enum Rank {
    first(2000000000,6,false,1),
    second(30000000,5,true,2),
    third(1500000,5,false,3),
    fourth(50000,4,false,4),
    fifth(5000,3,false,5),
    boom(0,0,false,0);
    private final Integer money;
    private final Integer matching;
    private final boolean hasBonus;
    private final Integer num;
    Rank(Integer money, Integer matching, boolean hasBonus, Integer num){
        this.money=money;
        this.matching=matching;
        this.hasBonus=hasBonus;
        this.num=num;
    }
    public static Rank getRank(Integer matchCount, boolean hasBonus){
        return Arrays.stream(values()).
                filter(rank -> Objects.equals(rank.matching, matchCount)).
                filter(rank -> rank.hasBonus== hasBonus).
                findAny().orElse(boom);
    }
    public static Rank findLottoRank(Lotto lotto, Lotto winningLotto, Integer bonusNum){
        final Integer matchCount=getMatchCount(lotto,winningLotto);
        boolean hasBonus=false;
        if(matchCount==5){
            hasBonus=lotto.hasNum(bonusNum);
        }
        return getRank(matchCount,hasBonus);
    }
    public static Integer getMatchCount(Lotto lotto, Lotto winningLotto){
        return (int)winningLotto.getNumbers().stream().filter(lotto::hasNum).count();
    }
    public Integer getMoney(){
        return money;
    }
    public Integer getNum(){
        return  num;
    }

}
