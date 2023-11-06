package lotto.model;

import java.util.EnumMap;

public class WinStatistics {
    private final EnumMap<Ranking, Integer> statistics;

    public WinStatistics(EnumMap<Ranking, Integer> statistics) {
        this.statistics = statistics;
    }
}
