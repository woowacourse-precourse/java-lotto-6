package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LotteryResults {
    private final Map<LotteryRanking, Integer> results;

    private LotteryResults() {
        this.results = new HashMap<>();
    }

    public LotteryResults(LotteryRanking ranking, int matches) {
        this();
        apply(ranking, matches);
    }

    public static LotteryResults emptyResults() {
        return new LotteryResults();
    }

    private void apply(LotteryRanking ranking, int matches) {
        int oldValue = results.getOrDefault(ranking, 0);
        results.put(ranking, oldValue + matches);
    }

    public LotteryResults applyResults(LotteryResults others) {
        for (LotteryRanking ranking : others.results.keySet()) {
            apply(ranking, others.results.get(ranking));
        }
        return this;
    }

    public long getTotalAmount() {
        return results.entrySet()
                .stream()
                .mapToLong(entry -> calculateAmount(entry))
                .sum();
    }

    private long calculateAmount(Map.Entry<LotteryRanking, Integer> entry) {
        return entry.getKey().getAmount() * entry.getValue();
    }
}
