package lotto.model;

import static lotto.constant.NumberConstant.HUNDRED;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record TotalWinningAmount(
        BigDecimal totalWinningAmount
) {

    public ReturnRate calculateReturnRateFrom(BigDecimal amount) {
        BigDecimal returnRate = totalWinningAmount
                .multiply(HUNDRED.getValue())
                .divide(amount, 1, RoundingMode.HALF_UP);
        return new ReturnRate(returnRate);
    }
}
