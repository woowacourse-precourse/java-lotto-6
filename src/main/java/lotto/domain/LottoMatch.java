package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LottoMatch {

    private static final int ZERO = 0;

    public Map<Rank, Integer> initializeLottoResult() {
        Map<Rank, Integer> result = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, ZERO);
        }
        return result;
    }
}
