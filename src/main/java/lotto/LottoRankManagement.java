package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoRankManagement {

    private Map<LottoRank, Integer> rankCounts;

    public LottoRankManagement() {
        rankCounts = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
    }
}
