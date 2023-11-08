package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private static final int DEFAULT_VALUE = 0;
    private static final int COUNT = 1;
    private static final double PERCENT = 100;

    private final Map<Rank, Integer> results;


    public LottoResult() {
        results = new HashMap<>();
        Arrays.stream(Rank.values())
                .forEach(rank -> results.put(rank, DEFAULT_VALUE));
    }

    public void addResult(Rank rank) {
        results.put(rank, results.get(rank) + COUNT);
    }

    public Map<Rank, Integer> getResults() {
        return Collections.unmodifiableMap(results);
    }

    public double getRateOfReturn(Money money) {
        double sumPrize = DEFAULT_VALUE;
        for (Map.Entry<Rank, Integer> entry : results.entrySet()) {
            sumPrize += (double) entry.getKey().getPrize() * (double) entry.getValue();
        }
        return (sumPrize / (double) money.getAmount()) * PERCENT;
    }
}
