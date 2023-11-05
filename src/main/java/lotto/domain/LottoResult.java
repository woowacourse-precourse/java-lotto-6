package lotto.domain;

import java.util.EnumMap;

public class LottoResult {

    private final EnumMap<LottoRank, Integer> rankCounts;

    private LottoResult(EnumMap<LottoRank, Integer> rankCounts) {
        this.rankCounts = rankCounts;
    }

    public static LottoResult from(EnumMap<LottoRank, Integer> rankCounts) {
        return new LottoResult(rankCounts);
    }

    public Integer getCountByRank(LottoRank rank) {
        return rankCounts.getOrDefault(rank, 0);
    }
}
