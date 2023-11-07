package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class WinningResult {
    private final Map<Prize, Integer> values = new EnumMap<>(Prize.class);

    public void addPrize(Prize prize) {
        values.put(prize, values.getOrDefault(prize, 0) + 1);
    }

    public Map<Prize, Integer> getValues() {
        return Collections.unmodifiableMap(values);
    }
}
