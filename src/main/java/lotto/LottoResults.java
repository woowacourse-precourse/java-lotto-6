package lotto;

import java.util.EnumMap;
import java.util.Map;

public class LottoResults {
    private final Map<LottoRank, Long> results;

    public LottoResults(Map<LottoRank, Long> results) {
        this.results = new EnumMap<>(results);
    }
}
