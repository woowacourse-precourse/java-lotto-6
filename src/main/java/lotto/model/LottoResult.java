package lotto.model;

import java.util.Map;

import lotto.util.Validator;

public class LottoResult {

    private final Map<Rank, Integer> rankInfo;

    public LottoResult(Map<Rank, Integer> rankingInfo) {
        this.rankInfo = rankingInfo;
    }

    public int getRankingCount(Rank rank) {
        return rankInfo.getOrDefault(rank, 0);
    }
}
