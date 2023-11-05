package lotto.model.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.model.domain.result.LottoResult;

public class Results {
    Map<LottoResult, Integer> map;

    public Results() {
        map = new HashMap<>();
        Arrays.stream(LottoResult.values())
                .filter(result -> result != LottoResult.LOSE)
                .forEach(result -> map.put(result, 0));
    }

    public void addResult(LottoResult result) {
        if (result.equals(LottoResult.LOSE)) {
            return;
        }
        map.put(result, map.get(result) + 1);
    }

    public List<Entry> getResults() {
        return Collections.unmodifiableList(
                map.entrySet()
                        .stream()
                        .sorted(Comparator.comparingInt(a -> a.getKey().ordinal()))
                        .toList()
        );
    }
}
