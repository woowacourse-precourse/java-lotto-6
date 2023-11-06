package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> result;

    public LottoResult(List<Lotto> lottos, WinLotto winLotto) {
        this.result = calculateResult(lottos, winLotto);
    }

    private Map<Rank, Integer> calculateResult(List<Lotto> lottos, WinLotto winLotto) {
        Map<Rank, Integer> map = new HashMap<>();
        lottos.stream()
                .map(winLotto::calculateRank)
                .forEach(rank -> map.put(rank, map.getOrDefault(rank, 0) + 1));
        return map;
    }

    public static LottoResult of(List<Lotto> lottos, WinLotto winLotto) {
        return new LottoResult(lottos, winLotto);
    }

    public Map<Rank, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }
}