package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResultManager {
    private final Map<Rank,Integer> lottoResult = new EnumMap<Rank, Integer>(Rank.class);

    public LottoResultManager(List<Rank> ranks) {
        //일단 모든 값 넣고
        //그다음 업데이트
        initEntry();
        updateRanksEntry(ranks);
        //lottoResult.remove(Rank.NOTHING);

        for (Map.Entry<Rank, Integer> entry : lottoResult.entrySet()) {
            //여기서 Output해야될득 요소값 하나씩 주고
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

    }

    private void initEntry(){ //초기화
        for (Rank rank : Rank.values()) {
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
