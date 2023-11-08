package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class RankResult {
    private static final int INITIAL_COUNT = 0;
    private static final int INCREMENT = 1;

    private final Map<LottoRank, Integer> results;

    private RankResult() {
        this.results = new EnumMap<>(LottoRank.class);
        initialize();
    }

    public static RankResult create() {
        return new RankResult();
    }

    private void initialize() {
        for (LottoRank lottoRank : LottoRank.values()) {
            results.put(lottoRank, INITIAL_COUNT);
        }
    }

    public void add(LottoRank lottoRank) {
        results.put(lottoRank, results.get(lottoRank) + INCREMENT);
    }

    public int getCount(LottoRank lottoRank) {
        return results.get(lottoRank);
    }

    public long calculateTotalWinnings() {
        return results.entrySet().stream()
                .mapToLong(entry -> (long) entry.getValue() * entry.getKey().getReward())
                .sum();
    }
}
