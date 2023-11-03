package lotto.domain;

import java.util.Map;

public class LottoResult {

    private final Map<Ranking, Integer> rankinInfo;
    private final int yield;

    public LottoResult(Map<Ranking, Integer> rankinInfo) {
        this.rankinInfo = rankinInfo;
        this.yield = 0;
    }

    public Map<Ranking, Integer> getRankinInfo() {
        return rankinInfo;
    }

    public int getYield() {
        return yield;
    }
}
