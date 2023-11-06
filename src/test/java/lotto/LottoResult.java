package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LottoResult {

    private Map<Rank, Integer> result = new HashMap<>();

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public void putRank(Rank rank) {
        result.put(rank, result.get(rank) + 1);
    }

    public long getTotalProfit() {
        long total = 0;
        for (Entry<Rank, Integer> entry : result.entrySet()) {
            Rank rank = entry.getKey();
            Integer count = entry.getValue();
            total += rank.prize() * count;
        }
        return total;
    }
}

