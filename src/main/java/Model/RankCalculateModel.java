package Model;

import lotto.Lotto;
import lotto.Rank;

import java.util.List;

public class RankCalcutateModel {
    private List<Rank> rankList;
    final private List<Lotto> lottoList;
    final private Lotto winningLotto;
    final private Integer bonusNum;
    public RankCalcutateModel(List<Lotto> lottoList, Lotto winningLotto, Integer bonusNum){
        this.lottoList = lottoList;
        this.winningLotto = winningLotto;
        this.bonusNum = bonusNum;
        makeRankList();
    }
    private void makeRankList(){
        for(Lotto lotto:lottoList){
            Rank rank=Rank.findLottoRank(lotto,winningLotto,bonusNum);
            rankList.add(rank);
        }
    }
    public List<Rank> getRankList(){
        return rankList;
    }

}
