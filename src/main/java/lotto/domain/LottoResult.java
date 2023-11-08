package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private static final int INITIAL_COUNT = 0;
    private static final int INCREASING_VALUE = 1;

    private final Map<LottoRanking, Integer> result = new EnumMap<>(LottoRanking.class);

    public void record(LottoRanking lottoRanking) {
        result.put(lottoRanking, result.getOrDefault(lottoRanking, INITIAL_COUNT) + INCREASING_VALUE);
    }

    public Map<LottoRanking, Integer> getResult() {
        return result;
    }
}
