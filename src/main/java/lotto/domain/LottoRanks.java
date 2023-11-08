package lotto.domain;

import lotto.constants.LottoRankConstants;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public record LottoRanks(Map<LottoRankConstants, Integer> ranks) {

    public LottoRanks() {
        this(EnumSet.allOf(LottoRankConstants.class).stream()
                .collect(Collectors.toMap(e -> e, e -> 0)));
    }

    public LottoRanks recordRank(final LottoRankConstants rank) {
        Map<LottoRankConstants, Integer> updatedRanks = new HashMap<>(ranks);
        updatedRanks.merge(rank, 1, Integer::sum);
        return new LottoRanks(updatedRanks);
    }

    public int getRankCount(LottoRankConstants rank) {
        return ranks.get(rank);
    }
}
