package lotto;

import java.util.EnumMap;
import java.util.Map;

public class LottoResults {
    private final Map<LottoRank, Integer> results;
    public LottoResults() {
        this.results = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            results.put(rank, 0);
        }
    }
    public void addResult(LottoRank rank) {
        results.merge(rank, 1, Integer::sum);
    }
    public int getCount(LottoRank rank) {
        return results.getOrDefault(rank, 0);
    }

}
