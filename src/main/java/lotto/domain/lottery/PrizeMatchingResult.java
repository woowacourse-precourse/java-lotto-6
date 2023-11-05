package lotto.domain.lottery;

import java.util.List;

public class PrizeMatchingResult {
    private final List<Integer> matchingCounts;

    private PrizeMatchingResult(
            Lottos lottos,
            Prize prize
    ) {
        Lotto prizeNumbers = prize.getPrizeNumbers();
        this.matchingCounts = lottos.calculateMatchingCount(prizeNumbers);
    }

    public static PrizeMatchingResult of(
            final Lottos lottos,
            final Prize prize
    ) {
        return new PrizeMatchingResult(lottos, prize);
    }

    public List<Integer> getMatchingNumberCounts() {
        return matchingCounts;
    }
}
