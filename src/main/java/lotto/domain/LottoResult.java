package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> results;

    public LottoResult() {
        results = new HashMap<>();
        Arrays.stream(Rank.values())
                .forEach(rank -> results.put(rank, 0));
    }

    public void addResult(Rank rank){
        results.put(rank, results.get(rank)+ 1);
    }

    public Map<Rank, Integer> getResults() {
        return Collections.unmodifiableMap(results);
    }

    public double getRateOfReturn(Money money){
        double sumPrize = 0;
        for (Map.Entry<Rank, Integer> entry : results.entrySet()) {
            sumPrize += entry.getKey().getPrize() * entry.getValue();
        }
        return sumPrize / money.getMoney() * 100;
    }
}
