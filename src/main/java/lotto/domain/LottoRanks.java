package lotto.domain;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public record LottoRanks(Map<LottoRank, Integer> ranks) {

    public LottoRanks() {
        this(EnumSet.allOf(LottoRank.class).stream()
                .collect(Collectors.toMap(e -> e, e -> 0)));
    }

    public LottoRanks recordRank(final LottoRank rank) {
        Map<LottoRank, Integer> updatedRanks = new HashMap<>(ranks);
        updatedRanks.merge(rank, 1, Integer::sum);
        return new LottoRanks(updatedRanks);
    }

    public int getRankCount(LottoRank rank) {
        return ranks.get(rank);
    }
}
