package lotto.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;

public final class TotalPrizeAmount {
    private static final String TOTAL_PRIZE_AMOUNT_EXCEPTION_FORMAT = "총 당첨금은 %d원 이상이어야 합니다.";
    private static final int MIN_TOTAL_PRIZE_AMOUNT = 0;
    private final long prizesAmount;

    private TotalPrizeAmount(long prizesAmount) {
        validateUnderMin(prizesAmount);
        this.prizesAmount = prizesAmount;
    }

    private void validateUnderMin(long prizesAmount) {
        if (prizesAmount < MIN_TOTAL_PRIZE_AMOUNT) {
            String exceptionMessage = String.format(TOTAL_PRIZE_AMOUNT_EXCEPTION_FORMAT, MIN_TOTAL_PRIZE_AMOUNT);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    public static TotalPrizeAmount from(long prizesAmount) {
        return new TotalPrizeAmount(prizesAmount);
    }

    public BigDecimal calculatePrizeToInvestmentRatio(int investment) {
        BigDecimal totalPrizeAmount = BigDecimal.valueOf(prizesAmount);
        BigDecimal investmentAmount = BigDecimal.valueOf(investment);

        return totalPrizeAmount.divide(investmentAmount, MathContext.DECIMAL64);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TotalPrizeAmount that = (TotalPrizeAmount) o;
        return prizesAmount == that.prizesAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizesAmount);
    }
}
