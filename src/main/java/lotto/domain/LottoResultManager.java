package lotto.domain;

import java.util.*;

public class LottoResultManager {
    private final Map<Rank,Integer> lottoResult = new EnumMap<>(Rank.class);
    private int totalPrize = 0;

    public LottoResultManager(List<Rank> ranks) {
        initEntry(); //초기화-모든 Rank를 담음
        updateRanksEntry(ranks); //매치된 Rank를 담음 ++1;
        lottoResult.remove(Rank.NOTHING);
        sumTotalPrize(ranks);
    }

    public Map<Rank,Integer> getLottoResult(){ //최종 출력을 위함
        return lottoResult;
    }

    public int getTotalPrize(){
        return totalPrize;
    }

    public void sumTotalPrize(List<Rank> ranks){
        for(Rank rank : ranks){
            totalPrize += Rank.findPrizeMoney(rank);
        }
    }

    private void initEntry(){
        for (Rank rank : Rank.values()) {
            System.out.println(rank);
            lottoResult.put(rank, 0);
        }
    }

    private void updateRanksEntry(List<Rank> ranks){
        for(Rank rank : ranks){
            lottoResult.merge(rank, 1, Integer::sum);
        }
    }
}
