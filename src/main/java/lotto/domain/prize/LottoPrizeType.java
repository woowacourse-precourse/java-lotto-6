package lotto.domain.prize;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Stream;

public enum LottoPrizeType {

    FIRST(new LottoPrizeCriteria(6, false), BigDecimal.valueOf(2000000000L)),
    SECOND(new LottoPrizeCriteria(5, true), BigDecimal.valueOf(30000000L)),
    THIRD(new LottoPrizeCriteria(5, false), BigDecimal.valueOf(1500000L)),
    FOURTH(new LottoPrizeCriteria(4, false), BigDecimal.valueOf(50000L)),
    FIFTH(new LottoPrizeCriteria(3, false), BigDecimal.valueOf(5000L));

    private static final int SECOND_OR_THIRD_PRIZE_WINNING_NUMBER_COUNT = 5;

    private final LottoPrizeCriteria criteria;
    private final BigDecimal amount;

    LottoPrizeType(LottoPrizeCriteria criteria, BigDecimal amount) {
        this.criteria = criteria;
        this.amount = amount;
    }

    public static Optional<LottoPrizeType> toPrizeType(int winningNumberCount, boolean matchesBonusNumber) {
        if (winningNumberCount == SECOND_OR_THIRD_PRIZE_WINNING_NUMBER_COUNT) {
            return Stream.of(SECOND, THIRD)
                    .filter(type -> type.needToMatchBonusNumber(matchesBonusNumber))
                    .findFirst();
        }
        return Stream.of(FIRST, FOURTH, FIFTH)
                .filter(type -> type.meetsWinningNumberCountCriteria(winningNumberCount))
                .findFirst();
    }

    private boolean needToMatchBonusNumber(boolean matchesBonusNumber) {
        return this.criteria.needToMatchBonusNumber(matchesBonusNumber);
    }

    private boolean meetsWinningNumberCountCriteria(int winningNumberCount) {
        return this.criteria.matchesWinningNumberCount(winningNumberCount);
    }

    public BigDecimal calculateAmount(Integer winningCount) {
        return this.amount.multiply(new BigDecimal(winningCount));
    }

    public int getWinningNumberCountCriterion() {
        return this.criteria.getWinningNumberCount();
    }

    public boolean needToMatchBonusNumber() {
        return this.criteria.needToMatchBonusNumber();
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

}
