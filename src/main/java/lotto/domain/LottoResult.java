package lotto.domain;

import lotto.domain.enums.LottoRank;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> lottoResult = new EnumMap<>(LottoRank.class);

    public LottoResult(List<LottoRank> ranks) {
        putRankCount(ranks);
    }

    private void putRankCount(List<LottoRank> ranks) {
        for (LottoRank rank : ranks) {
            lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
        }
    }

    public Map<LottoRank, Integer> getLottoResult() {
        return lottoResult;
    }
}
