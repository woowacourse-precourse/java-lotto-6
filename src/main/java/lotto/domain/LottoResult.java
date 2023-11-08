package lotto.domain;

import java.util.EnumMap;
import java.util.List;

public class LottoResult {
    private static final int DEFAULT_COUNT = 0;
    private static final int COUNT_INCREMENT_SIZE = 1;

    private final EnumMap<LottoRank, Integer> result;

    public LottoResult(List<LottoRank> ranks) {
        this.result = new EnumMap<>(LottoRank.class);

        for (LottoRank rank : ranks) {
            result.merge(rank, COUNT_INCREMENT_SIZE, Integer::sum);
        }
    }

    public int count(LottoRank rank) {
        return result.getOrDefault(rank, DEFAULT_COUNT);
    }
}
