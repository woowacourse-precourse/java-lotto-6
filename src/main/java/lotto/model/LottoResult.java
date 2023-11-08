package lotto.model;

import java.util.Map;

import lotto.util.Validator;

public class LottoResult {

    private final Map<Rank, Integer> rankInfo;
    private long totalPurchaseAmount = 0;

    public LottoResult(Map<Rank, Integer> rankingInfo) {
        this.rankInfo = rankingInfo;
    }

    public int getRankCount(Rank rank) {
        return rankInfo.getOrDefault(rank, 0);
    }

    public Map<Rank, Integer> getRankInfo() {
        return this.rankInfo;
    }

}
