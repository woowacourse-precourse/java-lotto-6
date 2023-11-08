package lotto.model;

import java.util.Map;

public class LottoResult {

    private final Map<Ranking, Integer> rankingInfo;
    private final Revenue revenue;

    public LottoResult(Map<Ranking, Integer> rankingResult, Revenue revenue) {
        this.rankingInfo = rankingResult;
        this.revenue = revenue;
    }

    public int getRankingCount(Ranking ranking) {
        return rankingInfo.getOrDefault(ranking, 0);
    }

    public double getRevenue() {
        return revenue.getValue();
    }
}