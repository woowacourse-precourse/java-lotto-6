package lotto.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;

public final class TotalWinningMoney {
    private static final String TOTAL_WINNING_MONEY_EXCEPTION_FORMAT = "총 당첨금은 %d원 이상이어야 합니다.";
    private static final int MIN_TOTAL_WINNING_MONEY = 0;
    private final long totalWinningMoney;

    private TotalWinningMoney(long totalWinningMoney) {
        validateUnderMin(totalWinningMoney);
        this.totalWinningMoney = totalWinningMoney;
    }

    private void validateUnderMin(long totalWinningMoney) {
        if (totalWinningMoney < MIN_TOTAL_WINNING_MONEY) {
            String exceptionMessage = String.format(TOTAL_WINNING_MONEY_EXCEPTION_FORMAT, MIN_TOTAL_WINNING_MONEY);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    public static TotalWinningMoney from(long totalWinningMoney) {
        return new TotalWinningMoney(totalWinningMoney);
    }

    public BigDecimal calculateReturnOnInvestment(int money) {
        BigDecimal totalWinningMoney = new BigDecimal(this.totalWinningMoney);
        BigDecimal investMoney = new BigDecimal(money);

        return totalWinningMoney.divide(investMoney, MathContext.DECIMAL64);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TotalWinningMoney that = (TotalWinningMoney) o;
        return totalWinningMoney == that.totalWinningMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalWinningMoney);
    }
}
