package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import lotto.model.calculate.MarginRate;
import lotto.model.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MarginRateTest {
    @DisplayName("구입금액과 당첨금액을 가지고 수익률을 계산할 수 있다.")
    @ParameterizedTest(name = "구입 금액 : {0}, 당첨 금액 : {1}, --> 계산결과 :{2}%")
    @CsvSource(value = {"8000,5000,62.5", "10000,15000,150.0"})
    void createMarginRate(String purchasingMoney, String totalRevenue, String expected) {
        MarginRate marginRate = new MarginRate(new Money(purchasingMoney), new Money(totalRevenue));

        BigDecimal result = marginRate.getMarginRateData();
        BigDecimal expectedResult = new BigDecimal(expected);

        assertThat(result).isEqualTo(expectedResult);
    }
}
