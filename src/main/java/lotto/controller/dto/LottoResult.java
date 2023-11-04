package lotto.controller.dto;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import lotto.domain.Rank;

public class LottoResult {

    private final Map<String, Integer> result;

    private LottoResult(final Map<String, Integer> result) {
        this.result = result;
    }

    public static LottoResult from(final Map<Rank, Integer> rankCounts) {
        Map<String, Integer> result = initResultMap();

        populateResultMap(rankCounts, result);

        return new LottoResult(result);
    }

    private static Map<String, Integer> initResultMap() {
        Map<String, Integer> result = new LinkedHashMap<>();

        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.BOOM)
                .forEach(rank -> result.put(rank.getPriceMessage(), 0));

        return result;
    }

    private static void populateResultMap(final Map<Rank, Integer> rankCounts, final Map<String, Integer> result) {
        rankCounts.entrySet()
                .stream()
                .filter(rank -> rank.getKey() != Rank.BOOM)
                .forEach(rank-> result.put(rank.getKey().getPriceMessage(), rank.getValue()));
    }

    public Map<String, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
