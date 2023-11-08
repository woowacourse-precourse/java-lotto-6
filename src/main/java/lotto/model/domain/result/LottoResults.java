package lotto.model.domain.result;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 각 로또 당첨 개수를 세기 위한 Map의 일급 컬렉션
 */
public class LottoResults {
    private final Map<LottoResult, Integer> map;

    public LottoResults() {
        map = new HashMap<>();
        Arrays.stream(LottoResult.values())
                .filter(result -> result != LottoResult.LOSE)
                .forEach(result -> map.put(result, 0));
    }

    /**
     * 당첨된 결과 개수를 추가합니다.
     */
    public void addResult(LottoResult result) {
        if (result.equals(LottoResult.LOSE)) {
            return;
        }
        map.put(result, map.get(result) + 1);
    }

    /**
     * 각 당첨 결과에 따른 당첨 횟수를 반환합니다.
     *
     * @return {@link List} - {@link LottoResultAndCount}를 하위 등수부터 정렬한 불변 리스트
     */
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
