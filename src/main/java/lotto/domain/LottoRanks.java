package lotto.domain;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoRanks {
    private static LottoRanks instance = new LottoRanks();
    private Map<LottoRank, Integer> ranks;
    private LottoRanks() {
        initilaze();
    }

    private void initilaze() {
        ranks = EnumSet.allOf(LottoRank.class).stream()
                .collect(Collectors.toMap(e -> e, e -> 0));
    }

    public static LottoRanks getInstance() {
        return instance;
    }

    public void increaseRankCount(LottoRank lottoRank) {
        ranks.put(lottoRank, ranks.get(lottoRank)+1);
    }

    public int getRankCount(LottoRank rank) {
        return ranks.get(rank);
    }
}
