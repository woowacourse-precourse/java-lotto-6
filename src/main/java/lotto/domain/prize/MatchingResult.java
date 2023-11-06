package lotto.domain.prize;

import lotto.domain.lottery.Lotto;
import lotto.domain.prize.constants.PrizeMatchingCount;

import java.util.Objects;

public class MatchingResult {
    private final PrizeMatchingCount prizeMatchingCount;
    private final boolean bonusMatching;

    private MatchingResult(
            Lotto lotto,
            Prize prize
    ) {
        int normalMatchingCount = lotto.countPrizeNumberMatchingCount(prize);

        this.prizeMatchingCount = PrizeMatchingCount.from(normalMatchingCount);
        this.bonusMatching = lotto.isBonusNumberMatching(prize);
    }

    public static MatchingResult of(
            Lotto lotto,
            Prize prize
    ) {
        return new MatchingResult(lotto, prize);
    }

    public boolean isSamePrizeMatchingCount(PrizeMatchingCount prizeMatchingCount) {
        return Objects.equals(this.prizeMatchingCount, prizeMatchingCount);
    }

    public boolean getMatchingBonus() {
        return bonusMatching;
    }
}
