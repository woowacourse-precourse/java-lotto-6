package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


public class LotteryResults {
    private final Map<LotteryRanking, Integer> results;

    private LotteryResults() {
        this.results = createEmptyLotteryRankingMap();
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

    public List<LotteryResult> toList() {
        return results.entrySet()
                .stream()
                .map(entry -> new LotteryResult(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    private long calculateAmount(Map.Entry<LotteryRanking, Integer> entry) {
        return entry.getKey().getAmount() * entry.getValue();
    }

    private Map<LotteryRanking, Integer> createEmptyLotteryRankingMap() {
        Map<LotteryRanking, Integer> result = new TreeMap<>();
        for (LotteryRanking ranking : LotteryRanking.values()) {
            result.put(ranking, 0);
        }
        return result;
    }
}
