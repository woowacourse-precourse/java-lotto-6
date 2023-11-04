package lotto.controller.dto;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import lotto.model.Rank;

public class WinningResult {

    private static final int DEFAULT_VALUE = 0;

    private final Map<String, Integer> result;

    private WinningResult(final Map<String, Integer> result) {
        this.result = result;
    }

    public static WinningResult from(final Map<Rank, Integer> rankCounts) {
        Map<String, Integer> result = new LinkedHashMap<>();

        Arrays.stream(Rank.values())
                .filter(Rank::isNotBoom)
                .forEach(rank -> result.put(rank.getPriceMessage(), rankCounts.getOrDefault(rank, DEFAULT_VALUE)));

        return new WinningResult(result);
    }

    public Map<String, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
