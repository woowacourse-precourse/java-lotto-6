package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Profit {
    private static final int PERCENT_SCALE = 100;
    private static final int DIVIDE_SCALE = 1;

    private final Money money;
    private final Lotteries lotteries;

    public Profit(final Money money, final Lotteries lotteries) {
        this.money = money;
        this.lotteries = lotteries;
    }

    public static Profit from(final Money money, final Lotteries lotteries) {
        return new Profit(money, lotteries);
    }

    public BigDecimal calculate(final UserLotto userLotto) {
        BigDecimal winningPrice = lotteries.calculateTotalWinningPrice(userLotto);
        BigDecimal amount = money.getAmount();

        return winningPrice.multiply(BigDecimal.valueOf(PERCENT_SCALE))
                .divide(amount, DIVIDE_SCALE, RoundingMode.HALF_UP);
    }
}
