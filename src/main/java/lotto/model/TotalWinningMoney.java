package lotto.model;

import java.math.BigDecimal;
import java.math.MathContext;

public class TotalWinningMoney {
    private static final String TOTAL_WINNING_MONEY_EXCEPTION_FORMAT = "총 당첨금은 %d원 이상이어야 합니다.";
    private static final int MIN_TOTAL_WINNING_MONEY = 0;
    private final long totalWinningMoney;

    private TotalWinningMoney(long totalWinningMoney) {
        validate(totalWinningMoney);
        this.totalWinningMoney = totalWinningMoney;
    }

    private void validate(long totalWinningMoney) {
        if (totalWinningMoney < MIN_TOTAL_WINNING_MONEY) {
            String exceptionMessage = String.format(TOTAL_WINNING_MONEY_EXCEPTION_FORMAT, MIN_TOTAL_WINNING_MONEY);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    public static TotalWinningMoney from(long totalWinningMoney) {
        return new TotalWinningMoney(totalWinningMoney);
    }

    public BigDecimal divide(int money) {
        BigDecimal totalWinning = new BigDecimal(totalWinningMoney);
        BigDecimal investment = new BigDecimal(money);
        return totalWinning.divide(investment, MathContext.DECIMAL64);
    }
}
