package lotto.domain;

import java.util.Map;

public class LottoResult {

    private final Map<Ranking, Integer> rankinInfo;
    private final double yield;

    public LottoResult(Map<Ranking, Integer> rankinInfo, double yield) {
        this.rankinInfo = rankinInfo;
        this.yield = yield;
    }

    public int getRankingCount(Ranking ranking) {
        return rankinInfo.getOrDefault(ranking, 0);
    }

    public double getYield() {
        return yield;
    }
}
