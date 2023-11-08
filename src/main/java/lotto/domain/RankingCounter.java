package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class RankingCounter {
    private final static int INIT_ZERO = 0;
    private final Map<String, Integer> counter;

    public RankingCounter() {
        this.counter = Arrays.stream(Ranking.values())
                .filter(Ranking::inRanking)
                .collect(Collectors.toMap(Enum::name, r -> INIT_ZERO));
    }

    public void addCount(String name) {
        counter.put(name, counter.get(name) + 1);
    }

    public Map<String, Integer> getCounter() {
        return Collections.unmodifiableMap(counter);
    }
}
