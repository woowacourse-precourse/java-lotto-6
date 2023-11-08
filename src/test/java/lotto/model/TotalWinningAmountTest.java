package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class TotalWinningAmountTest {
    @Test
    public void getReturnRateFrom() {
        String input = "10000";
        BigDecimal purchaseAmount = BigDecimal.valueOf(Long.parseLong(input));
        TotalWinningAmount totalWinningAmount = new TotalWinningAmount(BigDecimal.valueOf(24242424));
        ReturnRate returnRate = totalWinningAmount.calculateReturnRateFrom(purchaseAmount);

        assertThat(returnRate.returnRate())
                .isEqualTo(BigDecimal.valueOf(242424.24));
    }
}