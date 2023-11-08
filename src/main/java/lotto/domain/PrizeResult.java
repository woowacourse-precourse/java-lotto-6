package lotto.domain;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PrizeResult {
    private final Map<Ranking, Integer> prizeResult = new EnumMap<>(Ranking.class);

    public PrizeResult(List<Ranking> rankings) {
        putValues(rankings);
    }

    public long calculatePrizeSum() {
        return prizeResult.entrySet().stream()
                .mapToLong(entry -> entry.getKey().multiple(entry.getValue()))
                .sum();
    }

    public Map<Ranking, Integer> newPrizeResult() {
        if (prizeResult.isEmpty()) {
            throw new IllegalStateException("No prize results available.");
        }
        return new HashMap<>(prizeResult);
    }

    private void putValues(List<Ranking> rankings) {
        for (Ranking ranking : rankings) {
            prizeResult.put(ranking, prizeResult.getOrDefault(ranking, 0) + 1);
        }
    }
}