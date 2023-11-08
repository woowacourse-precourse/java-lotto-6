package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningResult {
    private final Map<Rank, Integer> values = new EnumMap<>(Rank.class);

    public void addPrize(Rank rank) {
        values.put(rank, values.getOrDefault(rank, 0) + 1);
    }

    public Map<Rank, Integer> getValues() {
        return Collections.unmodifiableMap(values);
    }

    public String getFormattedStatistics() {
        return Arrays.stream(Rank.values())
            .filter(rank -> !rank.equals(Rank.NONE))
            .map(rank -> rank.getStatisticsFormat().formatted(values.getOrDefault(rank, 0)))
            .collect(Collectors.joining("\n"));
    }
}
