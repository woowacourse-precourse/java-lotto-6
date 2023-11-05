package lotto.domain.prize;

import lotto.domain.lottery.Lotto;
import lotto.domain.prize.constants.PrizeMatchingCount;

public class MatchingResult {
    private final PrizeMatchingCount prizeMatchingCount;
    private final boolean bonusMatching;

    private MatchingResult(
            Lotto lotto,
            Prize prize
    ) {
        int normalMatchingCount = lotto.countPrizeNumberMatchingCount(prize);
        
        this.prizeMatchingCount = PrizeMatchingCount.convert(normalMatchingCount);
        this.bonusMatching = lotto.isBonusNumberMatching(prize);
    }

    public static MatchingResult of(
            Lotto lotto,
            Prize prize
    ) {
        return new MatchingResult(lotto, prize);
    }
}
