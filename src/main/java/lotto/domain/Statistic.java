package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistic {
    private final Map<LottoRank, Integer> lottoRankCount;
    private int lottoEarnings;
    public Statistic(List<LottoRank> rankList) {
        lottoRankCount = new HashMap<>();
        lottoEarnings = 0;
        for (LottoRank lottoRank : LottoRank.values()) {
            lottoRankCount.put(lottoRank, 0);
        }
        for (LottoRank rank : rankList) {
            int count = lottoRankCount.get(rank) + 1;
            lottoRankCount.put(rank,count);
            lottoEarnings += rank.getPrize();
        }
    }


    public Map<LottoRank, Integer> getLottoRankCount() {
        return lottoRankCount;
    }

    public int getLottoEarnings() {
        return lottoEarnings;
    }
}
