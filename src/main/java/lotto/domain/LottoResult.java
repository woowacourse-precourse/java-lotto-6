package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private final EnumMap<LottoRanking, Integer> lottoRankingResult;

    public LottoResult(EnumMap<LottoRanking, Integer> lottoRankingResult) {
        this.lottoRankingResult = lottoRankingResult;
    }

    public long calculateTotalPrize() {
        return lottoRankingResult.keySet().stream()
                .mapToLong(ranking -> {
                    Integer count = lottoRankingResult.getOrDefault(ranking, 0);
                    return ranking.getTotalPrize(count);
                })
                .sum();
    }

    public Map<LottoRanking, Integer> getResult() {
        return Map.copyOf(lottoRankingResult);
    }
}
