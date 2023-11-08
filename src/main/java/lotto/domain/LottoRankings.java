package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoRankings {

    private final List<LottoRanking> rankings;

    public LottoRankings(List<LottoRanking> rankings) {
        this.rankings = rankings;
    }

    public long calculateTotalPrize() {
        return rankings.stream()
                .mapToInt(LottoRanking::getPrize)
                .sum();
    }

    public Map<LottoRanking, Integer> getResult() {
        EnumMap<LottoRanking, Integer> lottoRankingResult = new EnumMap<>(LottoRanking.class);

        for (LottoRanking ranking : rankings) {
            Integer prevCount = lottoRankingResult.getOrDefault(ranking, 0);
            lottoRankingResult.put(ranking, prevCount + 1);
        }
        return lottoRankingResult;
    }
}
