package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoResultManager {
    private final Map<Rank,Integer> lottoResult = new EnumMap<>(Rank.class);

    private int totalPrize = 0;

    public LottoResultManager(List<Rank> ranks) {
        //일단 모든 값 넣고
        //그다음 업데이트
        initEntry();
        updateRanksEntry(ranks);
        lottoResult.remove(Rank.NOTHING);
        sumTotalPrize(ranks);
    }

    public Map<Rank,Integer> getLottoResult(){ //최종 출력을 위함

        return lottoResult;
    }

    public void sumTotalPrize(List<Rank> ranks){
        for(Rank rank : ranks){
            totalPrize += Rank.findPrizeMoney(rank);
        }
    }

    public int getTotalPrize(){
        return totalPrize;
    }

    private void initEntry(){ //초기화
        for (Rank rank : Rank.values()) {
            System.out.println(rank);
            lottoResult.put(rank, 0);
        }
    }
    private void updateRanksEntry(List<Rank> ranks){
        for(Rank rank : ranks){
            lottoResult.merge(rank, 1, Integer::sum);
            //lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
        }
    }
}
