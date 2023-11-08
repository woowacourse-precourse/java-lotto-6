package Model;

import lotto.Lotto;

import java.util.Arrays;
import java.util.Objects;

public enum RankCalculateModel {
    first(2000000000,6,false),
    second(30000000,5,true),
    third(1500000,5,false),
    fourth(50000,4,false),
    fifth(5000,3,false),
    boom(0,0,false);
    private final Integer money;
    private final Integer matching;
    private final boolean hasBonus;
    RankCalculateModel(Integer money, Integer matching, boolean hasBonus){
        this.money=money;
        this.matching=matching;
        this.hasBonus=hasBonus;
    }
    public RankCalculateModel getRank(Integer matchCount, boolean hasBonus){
        return Arrays.stream(values()).
                filter(rankCalculateModel -> Objects.equals(rankCalculateModel.matching, matchCount)).
                filter(rankCalculateModel -> rankCalculateModel.hasBonus== hasBonus).
                findAny().orElse(boom);
    }
    public RankCalculateModel findLottoRank(Lotto lotto, Lotto winningLotto, Integer bonusNum){
        final Integer matchCount=getMatchCount(lotto,winningLotto);
        boolean hasBonus=false;
        if(matchCount==5){
            hasBonus=lotto.hasNum(bonusNum);
        }
        return getRank(matchCount,hasBonus);
    }
    public Integer getMatchCount(Lotto lotto, Lotto winningLotto){
        return (int)winningLotto.getNumbers().stream().filter(lotto::hasNum).count();
    }
    public Integer getMoney(){
        return money;
    }

}
