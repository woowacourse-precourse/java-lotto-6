package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ProfitRateTest {

    @DisplayName("구입 금액에 대한 수익률을 계산한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "8000:5000:62.5", "5000:230000000:4600000", "7000:1510000:21571.4",
            "5000:2031555000:40631100", "7000:3105000:44357.1", "1500000:55000:3.7"
    }, delimiter = ':')
    void givenPurchaseAmount_Then_ProfitRateReturns(
            final long purchaseAmount,
            final long totalWinningAmount,
            final double expectedProfit
    ) {
        final Money money = Money.of(purchaseAmount);
        final BigDecimal totalAmount = BigDecimal.valueOf(totalWinningAmount);
        final ProfitRate profitRate = new ProfitRate(money, totalAmount);
        assertThat(profitRate.doubleValue()).isEqualTo(expectedProfit, withPrecision(0d));
    }
}
