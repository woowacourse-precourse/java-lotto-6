package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DrawingResults {
    public static final int INIT_MATCH_RANK_COUNT = 0;
    private final Map<Rank, Integer> results = new LinkedHashMap<>();

    public DrawingResults() {
        List<Rank> ranks = Arrays.stream(Rank.values()).toList();

        for (Rank rank : ranks) {
            results.put(rank, INIT_MATCH_RANK_COUNT);
        }
    }

    public void count(final Rank calculateResult) {
        Set<Entry<Rank, Integer>> entries = results.entrySet();

        entries.forEach(result -> {
            if (result.getKey() == calculateResult) {
                result.setValue(result.getValue() + 1);
            }
        });
    }

    public Map<Rank, Integer> getResults() {
        return results;
    }
}