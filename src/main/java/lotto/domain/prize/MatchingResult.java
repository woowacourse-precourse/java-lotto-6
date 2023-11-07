package lotto.domain.prize;

import lotto.domain.lottery.Lotto;
import lotto.domain.prize.constants.PrizeMatchingCount;

import java.util.Objects;

public class MatchingResult {
    private final PrizeMatchingCount prizeMatchingCount;
    private final boolean bonusMatching;

    // Constructor
    private MatchingResult(
            final Lotto lotto,
            final Prize prize
    ) {
        final int normalMatchingCount = lotto.countPrizeNumberMatchingCount(prize);

        this.prizeMatchingCount = PrizeMatchingCount.from(normalMatchingCount);
        this.bonusMatching = lotto.hasBonusNumber(prize);
    }

    // Static Factory Method
    public static MatchingResult of(
            final Lotto lotto,
            final Prize prize
    ) {
        return new MatchingResult(lotto, prize);
    }

    // Utility Method
    public boolean isSamePrizeMatchingCount(PrizeMatchingCount prizeMatchingCount) {
        return Objects.equals(this.prizeMatchingCount, prizeMatchingCount);
    }

    // Getter


    public PrizeMatchingCount getPrizeMatchingCount() {
        return prizeMatchingCount;
    }

    public boolean getBonusMatching() {
        return bonusMatching;
    }
}
