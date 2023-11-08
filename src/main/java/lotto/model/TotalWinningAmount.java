package lotto.model;

import static lotto.constant.NumberConstant.HUNDRED;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public record TotalWinningAmount(
        BigDecimal totalWinningAmount
) {

    public ReturnRate calculateReturnRateFrom(final BigDecimal amount) {
        Objects.requireNonNull(amount);
        BigDecimal returnRate = totalWinningAmount
                .multiply(HUNDRED.getValue())
                .divide(amount, 1, RoundingMode.HALF_UP);
        return new ReturnRate(returnRate);
    }
}
