package lotto.model.domain.result;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResults {
    private final Map<LottoResult, Integer> map;

    public LottoResults() {
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

    public List<LottoResultAndCount> getResultAndCounts() {
        return Collections.unmodifiableList(
                map.entrySet()
                        .stream()
                        .sorted((a, b) -> b.getKey().ordinal() - a.getKey().ordinal())
                        .map(entry -> new LottoResultAndCount(entry.getKey(), entry.getValue()))
                        .toList()
        );
    }
}
