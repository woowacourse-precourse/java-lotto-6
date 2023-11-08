package lotto.domain;

import lotto.constants.LottoRank;

import java.util.HashMap;
import java.util.Map;

public class RankCounts {

    private final Map<LottoRank, Integer> rankCounts;

    public RankCounts() {
        this.rankCounts = new HashMap<>();
    }

    public void update(LottoRank lottoRank) {
        int nowCount = rankCounts.getOrDefault(lottoRank, 0);
        rankCounts.put(lottoRank, nowCount + 1);
    }
}
