package lotto.repository;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.constants.LottoRankConstants;

public class LottoRanks {

    private Map<LottoRankConstants, Integer> ranks;

    public LottoRanks() {
        this.ranks = EnumSet.allOf(LottoRankConstants.class).stream()
                .collect(Collectors.toMap(e -> e, e -> 0));
    }

    private LottoRanks(Map<LottoRankConstants, Integer> ranks) {
        this.ranks = new HashMap<>(ranks);
    }

    public void recordRank(final LottoRankConstants rank) {
        this.ranks.merge(rank, 1, Integer::sum);
    }

    public int getRankCount(LottoRankConstants rank) {
        return ranks.get(rank);
    }
}
