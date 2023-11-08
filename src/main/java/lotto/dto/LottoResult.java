package lotto.dto;

import lotto.domain.Ranking;
import lotto.domain.Yield;

import java.util.Map;

public class LottoResult {

    private final Map<Ranking, Integer> rankingInfo;
    private final Yield yield;

    public LottoResult(Map<Ranking, Integer> rankingInfo, Yield yield) {
        this.rankingInfo = rankingInfo;
        this.yield = yield;
    }

    public int getRankingCount(Ranking ranking) {
        return rankingInfo.getOrDefault(ranking, 0);
    }

    public double getYield() {
        return yield.getValue();
    }
}
