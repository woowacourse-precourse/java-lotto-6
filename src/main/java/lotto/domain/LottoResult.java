package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> results = new HashMap<>();

    public void addResult(Rank rank){
        results.put(rank, results.getOrDefault(rank, 0) + 1);
    }

    public int getResult(Rank rank) {
        return results.get(rank);
    }
}
