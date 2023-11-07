package lotto.domain.prize.constants;

import lotto.domain.prize.MatchingResult;
import lotto.exception.LottoException;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import static lotto.domain.prize.constants.PrizeMatchingCount.*;
import static lotto.exception.ErrorMessage.SYSTEM_CRASHED;

public enum PrizeGrade {
    HIT_SIX(SIX,
            always -> true,
            2_000_000_000
    ),
    HIT_FIVE_AND_BONUS(FIVE,
            keep -> keep,
            30_000_000
    ),
    HIT_FIVE(FIVE,
            reverse -> !reverse,
            1_500_000
    ),
    HIT_FOUR(FOUR,
            always -> true,
            50_000
    ),
    HIT_THREE(THREE,
            always -> true,
            5_000
    ),
    HIT_TWO(TWO,
            always -> true,
            0
    ),
    HIT_ONE(ONE,
            always -> true,
            0
    ),
    HIT_ZERO(ZERO,
            always -> true,
            0
    );

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

    // Utility Method
    public static PrizeGrade findPrizeGrade(final MatchingResult matchingResult) {
        return Arrays.stream(PrizeGrade.values())
                .filter(findGradeByCount(matchingResult))
                .filter(isSatisfyBonusCondition(matchingResult))
                .findFirst()
                .orElseThrow(() -> LottoException.from(SYSTEM_CRASHED));
    }

    // Validation Method
    private static Predicate<PrizeGrade> findGradeByCount(MatchingResult matchingResult) {
        return grade -> matchingResult.isSamePrizeMatchingCount(grade.prizeMatchingCount);
    }

    private static Predicate<PrizeGrade> isSatisfyBonusCondition(MatchingResult matchingResult) {
        return grade -> grade.matchingBonus.apply(matchingResult.getBonusMatching());
    }

    // Getter
    public int getPrizeMatchingCount() {
        return prizeMatchingCount.getCount();
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
