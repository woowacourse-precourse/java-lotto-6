package lotto.controller.dto;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import lotto.domain.Rank;

public class WinningResult {

    private final Map<String, Integer> result;

    private WinningResult(final Map<String, Integer> result) {
        this.result = result;
    }

    public static WinningResult from(final Map<Rank, Integer> rankCounts) {
        Map<String, Integer> result = initResultMap();

        populateResultMap(rankCounts, result);

        return new WinningResult(result);
    }

    private static Map<String, Integer> initResultMap() {
        Map<String, Integer> result = new LinkedHashMap<>();

        Arrays.stream(Rank.values())
                .filter(Rank::isNotBoom)
                .forEach(rank -> result.put(rank.getPriceMessage(), 0));

        return result;
    }

    private static void populateResultMap(final Map<Rank, Integer> rankCounts, final Map<String, Integer> result) {
        rankCounts.entrySet()
                .stream()
                .filter(rank -> rank.getKey().isNotBoom())
                .forEach(rank -> result.put(rank.getKey().getPriceMessage(), rank.getValue()));
    }

    public Map<String, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
