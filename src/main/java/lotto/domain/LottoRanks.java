package lotto.domain;

import static lotto.constants.LottoConstants.INCREASING_UNIT;
import static lotto.constants.LottoConstants.INITIAL_VALUE;

import java.util.EnumSet;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.constants.RankConstants;

public class LottoRanks {
    private Map<RankConstants, Integer> ranks;

    public LottoRanks() {
        this.ranks = EnumSet.allOf(RankConstants.class).stream()
                .collect(Collectors.toMap(e -> e, e -> INITIAL_VALUE));
    }

    public void recordRank(final RankConstants rank) {
        this.ranks.merge(rank, INCREASING_UNIT, Integer::sum);
    }

    public int getRankCount(RankConstants rank) {
        return ranks.get(rank);
    }
}
