package lotto.domain.prize.ranking;

import java.util.Collections;
import java.util.EnumMap;
import lotto.domain.prize.ranking.rule.PrizeRanking;

public class PrizeRankingCount {
    private final EnumMap<PrizeRanking, Integer> prizeRankingCount;

    public PrizeRankingCount(final EnumMap<PrizeRanking, Integer> prizeRankingCount) {
        this.prizeRankingCount = prizeRankingCount;
    }

    public EnumMap<PrizeRanking, Integer> getPrizeRankingCount() {
        return new EnumMap<>(Collections.unmodifiableMap(prizeRankingCount));
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null) {
            return false;
        }

        if (!(other instanceof PrizeRankingCount otherPrizeRankingCount)) {
            return false;
        }

        return prizeRankingCount.equals(otherPrizeRankingCount.prizeRankingCount);
    }
}
