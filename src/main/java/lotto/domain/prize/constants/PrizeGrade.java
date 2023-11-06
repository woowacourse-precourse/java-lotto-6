package lotto.domain.prize.constants;

import lotto.domain.prize.MatchingResult;
import lotto.exception.LottoException;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import static lotto.domain.prize.constants.PrizeMatchingCount.*;
import static lotto.exception.ErrorMessage.SYSTEM_CRASHED;

public enum PrizeGrade {
    HIT_SIX(SIX, always -> true, 200_000_000),
    HIT_FIVE_AND_BONUS(FIVE, keep -> keep, 30_000_000),
    HIT_FIVE(FIVE, reverse -> !reverse, 1_500_000),
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
                .filter(findSameMatchingCount(matchingResult))
                .filter(findMatchingCase(matchingResult))
                .findFirst()
                .orElseThrow(() -> LottoException.from(SYSTEM_CRASHED));
    }

    private static Predicate<PrizeGrade> findSameMatchingCount(MatchingResult matchingResult) {
        return rank -> matchingResult.isSamePrizeMatchingCount(rank.prizeMatchingCount);
    }

    private static Predicate<PrizeGrade> findMatchingCase(MatchingResult matchingResult) {
        return rank -> rank.matchingBonus.apply(matchingResult.getMatchingBonus());
    }
    
    public int getPrizeAmount() {
        return prizeAmount;
    }
}
