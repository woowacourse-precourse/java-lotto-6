package lotto.domain;

import lotto.constant.Ranking;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private static final int DEFAULT = 0;
    private static final int INCREASING_COUNT = 1;
    private final Map<Ranking, Integer> result = new EnumMap<>(Ranking.class);

    public LottoResult() {
        Arrays.stream(Ranking.values()).forEach(value -> result.put(value, DEFAULT));
    }

    public void increaseCount(Ranking ranking) {
        int now = result.get(ranking);
        result.put(ranking, now + INCREASING_COUNT);
    }
}
