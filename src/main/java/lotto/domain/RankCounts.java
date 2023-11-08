package lotto.domain;

import lotto.constants.LottoRank;

import java.util.HashMap;
import java.util.Map;

import static lotto.constants.Constants.Integers.INTEGER_ZERO;
import static lotto.constants.Constants.Integers.RANK_COUNT_INCREASE;

public class RankCounts {

    private final Map<LottoRank, Integer> rankCounts;

    public RankCounts() {
        this.rankCounts = new HashMap<>();
    }

    public void update(LottoRank lottoRank) {
        int nowCount = rankCounts.getOrDefault(lottoRank, INTEGER_ZERO.getValue());
        rankCounts.put(lottoRank, nowCount + RANK_COUNT_INCREASE.getValue());
    }

    public Integer getRankCount(LottoRank lottoRank) {
        return rankCounts.getOrDefault(lottoRank, 0);
    }
}
