package lotto;

import java.util.LinkedHashMap;
import java.util.Map;

public class LottoResult {

    private final Map<Rank,Integer> lottoResultTable = new LinkedHashMap<>();

    public LottoResult(){
        for (Rank rank : Rank.values()) {
            lottoResultTable.put(rank, 0);
        }
    }

    public Map<Rank, Integer> getLottoResultTable() {
        return lottoResultTable;
    }

    public void addNumberOfMatch(Rank rank){
        int currentCount = lottoResultTable.get(rank);
        lottoResultTable.put(rank,currentCount+1);
    }
}
