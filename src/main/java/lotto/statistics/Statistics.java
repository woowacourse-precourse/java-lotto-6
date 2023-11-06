package lotto.statistics;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.ranking.Ranking;

public class Statistics {

    private static final int INITIAL_COUNT = 0;

    private final Map<Ranking, Integer> statistics;

    public Statistics(List<Ranking> rankings) {
        this.statistics = new HashMap<>();
        initStatistics();
        calculateDistribution(rankings);
    }

    private void initStatistics() {
        for (Ranking ranking : Ranking.values()) {
            statistics.put(ranking, INITIAL_COUNT);
        }
    }

    private void calculateDistribution(List<Ranking> rankings) {
        rankings.forEach(ranking -> statistics.computeIfPresent(ranking, (key, count) -> ++count));
    }

    public Map<Ranking, Integer> getStatistics() {
        return Collections.unmodifiableMap(statistics);
    }
}
