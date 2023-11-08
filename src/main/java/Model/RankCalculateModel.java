package Model;

import lotto.Lotto;
import lotto.Rank;

import javax.management.relation.RelationNotification;
import java.util.*;

public class RankCalculateModel {
    private final List<Rank> rankList=new ArrayList<>();
    private final Integer firstRank;
    private final Integer secondRank;
    private final Integer thirdRank;
    private final Integer fourthRank;
    private final Integer fifthRank;
    private final Integer boomRank;
    public RankCalculateModel(List<Lotto> lottoList, Lotto winningLotto, Integer bonusNum){
        for(Lotto lotto:lottoList){
            rankList.add(Rank.findLottoRank(lotto,winningLotto,bonusNum));
        }
        firstRank= Collections.frequency(rankList, Rank.first);
        secondRank= Collections.frequency(rankList, Rank.second);
        thirdRank= Collections.frequency(rankList, Rank.third);
        fourthRank= Collections.frequency(rankList, Rank.fourth);
        fifthRank= Collections.frequency(rankList, Rank.fifth);
        boomRank= Collections.frequency(rankList, Rank.boom);
    }
    public List<Rank> getRankList(){
        return this.rankList;
    }
    public Integer getFirstRank(){
        return firstRank;
    }
    public Integer getSecondRank(){
        return secondRank;
    }
    public Integer getThirdRank(){
        return thirdRank;
    }
    public Integer getFourthRank(){
        return fourthRank;
    }
    public Integer getFifthRank(){
        return fifthRank;
    }
    public Integer getBoomRank(){
        return boomRank;
    }
    public void printRank(){
        System.out.println("3개 일치 (5,000원) - "+fifthRank+"개");
        System.out.println("4개 일치 (50,000원) - "+fourthRank+"개");
        System.out.println("5개 일치 (1,500,000원) - "+thirdRank+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+secondRank+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+firstRank+"개");
    }
}
