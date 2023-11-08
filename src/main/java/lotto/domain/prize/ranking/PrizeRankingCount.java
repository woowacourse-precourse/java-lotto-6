package lotto.domain.prize.ranking;

import java.util.Collections;
import java.util.Map;
import lotto.domain.prize.ranking.rule.PrizeRanking;

public class PrizeRankingCount {
    private final Map<PrizeRanking, Integer> prizeRankingCount;

    public PrizeRankingCount(final Map<PrizeRanking, Integer> prizeRankingCount) {
        this.prizeRankingCount = prizeRankingCount;
    }

    public Map<PrizeRanking, Integer> getPrizeRankingCount() {
        return Collections.unmodifiableMap(prizeRankingCount);
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
