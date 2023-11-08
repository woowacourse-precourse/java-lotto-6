package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.Prize;

public class RankingCounter {
    private final static int INIT_ZERO = 0;
    private final Map<String, Integer> counter;

    public RankingCounter() {
        this.counter = Arrays.stream(Ranking.values())
                .filter(Ranking::inRanking)
                .collect(Collectors.toMap(Enum::name, r -> INIT_ZERO));
    }

    public void addCount(Ranking ranking) {
        if (ranking.inRanking()) {
            counter.put(ranking.name(), counter.get(ranking.name()) + 1);
        }
    }

    public Map<String, Integer> getCounter() {
        return Collections.unmodifiableMap(counter);
    }

    public long getPrizeMoney() {
        return counter.entrySet()
                .stream()
                .mapToLong(entry -> (long) Prize.valueOf(entry.getKey()).value() * entry.getValue()).sum();
    }
}
