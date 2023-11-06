package lotto.domain.prize.constants;

import lotto.domain.prize.MatchingResult;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

import java.util.Arrays;
import java.util.function.UnaryOperator;

import static lotto.domain.prize.constants.PrizeMatchingCount.*;

public enum PrizeGrade {
    HIT_SIX(SIX, always -> true, 200_000_000),
    HIT_FIVE_AND_BONUS(FIVE, positive -> positive, 30_000_000),
    HIT_FIVE(FIVE, negative -> !negative, 1_500_000),
    HIT_FOUR(FOUR, always -> true, 50_000),
    HIT_THREE(THREE, always -> true, 5_000),
    HIT_TWO(TWO, always -> true, 0),
    HIT_ONE(ONE, always -> true, 0),
    HIT_ZERO(ZERO, always -> true, 0);

    private final PrizeMatchingCount prizeMatchingCount;
    private final UnaryOperator<Boolean> matchingBonus;
    private final int prizeAmount;

    PrizeGrade(
            PrizeMatchingCount prizeMatchingCount,
            UnaryOperator<Boolean> matchingBonus,
            int prizeAmount
    ) {
        this.prizeMatchingCount = prizeMatchingCount;
        this.matchingBonus = matchingBonus;
        this.prizeAmount = prizeAmount;
    }
    
    public static PrizeGrade findPrizeRank(final MatchingResult matchingResult) {
        return Arrays.stream(PrizeGrade.values())
                .filter(rank -> matchingResult.isSamePrizeMatchingCount(rank.prizeMatchingCount))
                .filter(rank -> rank.matchingBonus.apply(matchingResult.isMatchingBonus()))
                .findFirst()
                .orElseThrow(() -> LottoException.from(ErrorMessage.SYSTEM_CRASHED));
    }

    public PrizeMatchingCount getPrizeMatchingCount() {
        return prizeMatchingCount;
    }
}
