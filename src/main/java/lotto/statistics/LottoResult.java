package lotto.statistics;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.ranking.Ranking;

public class LottoResult {
    private static final int INITIAL_COUNT = 0;

    private final Map<Ranking, Integer> lottoResult;

    public LottoResult(List<Ranking> rankings) {
        this.lottoResult = new HashMap<>();
        initResult();
        calculateDistribution(rankings);
    }

    private void initResult() {
        for (Ranking ranking : Ranking.values()) {
            lottoResult.put(ranking, INITIAL_COUNT);
        }
    }

    private void calculateDistribution(List<Ranking> rankings) {
        rankings.forEach(ranking -> lottoResult.computeIfPresent(ranking, (key, count) -> ++count));
    }

    public Integer getRankingCount(Ranking ranking) {
        return lottoResult.get(ranking);
    }

    public Map<Ranking, Integer> getLottoResult() {
        return Collections.unmodifiableMap(lottoResult);
    }
}
