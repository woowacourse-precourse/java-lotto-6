package lotto.model;

import java.util.EnumMap;
import java.util.List;

public class WinStatistics {
    private final EnumMap<Ranking, Integer> statistics;

    private WinStatistics(EnumMap<Ranking, Integer> statistics) {
        this.statistics = statistics;
    }

    public static WinStatistics from(List<Ranking> rankings) {
        return new WinStatistics(createStatistics(rankings));
    }

    private static EnumMap<Ranking, Integer> createStatistics(List<Ranking> rankings) {
        return rankings.stream()
                .collect(
                        () -> new EnumMap<>(Ranking.class),
                        (map, ranking) -> map.put(ranking, map.getOrDefault(ranking, 0) + 1),
                        EnumMap::putAll
                );
    }

    public EnumMap<Ranking, Integer> getStatistics() {
        return statistics;
    }
}
