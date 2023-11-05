package lotto.domain;

import java.util.List;
import lotto.constant.Rank;

public final class PrizeCalculator {

    public long calculatePrize(List<Rank> ranks) {
        return ranks.stream()
            .mapToLong(Rank::getPrize)
            .sum();
    }
}
