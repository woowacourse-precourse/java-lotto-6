package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import lotto.stub.TotalWinningAmountStub;
import org.junit.jupiter.api.Test;

class TotalWinningAmountTest extends TotalWinningAmountStub {
    @Test
    public void getReturnRateFrom() {
        BigDecimal purchaseAmount = BigDecimal.valueOf(Long.parseLong(INPUT));
        TotalWinningAmount totalWinningAmount = new TotalWinningAmount(BigDecimal.valueOf(WINNING_AMOUNT));
        ReturnRate returnRate = totalWinningAmount.calculateReturnRateFrom(purchaseAmount);

        assertThat(returnRate.returnRate())
                .isEqualTo(BigDecimal.valueOf(CALCULATED_RETURN_RATE));
    }
}