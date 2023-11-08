package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class WinningResult {
    private final Map<Rank, Integer> values = new EnumMap<>(Rank.class);

    public void addPrize(Rank rank) {
        values.put(rank, values.getOrDefault(rank, 0) + 1);
    }

    public Map<Rank, Integer> getValues() {
        return Collections.unmodifiableMap(values);
    }
}
