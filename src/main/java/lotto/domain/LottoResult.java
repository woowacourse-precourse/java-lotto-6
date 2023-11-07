package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> results = new HashMap<>();

    public void addResult(Rank rank){
        results.put(rank, results.getOrDefault(rank, -1) + 1);
    }

    public int getResult(Rank rank) {
        return results.get(rank);
    }

    public long getRateOfReturn(){
        long sumPrize = 0;
        long lottoCount = 0;
        for (Map.Entry<Rank, Integer> entry : results.entrySet()) {
            sumPrize += entry.getKey().getPrize() * entry.getValue();
            lottoCount++;
        }

        return sumPrize/lottoCount;
    }
}
