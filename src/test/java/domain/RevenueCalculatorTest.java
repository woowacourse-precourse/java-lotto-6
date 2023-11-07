package domain;

import lotto.domain.model.Money;
import lotto.domain.caclulator.RevenueCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RevenueCalculatorTest {

    @ParameterizedTest
    @CsvSource({"2000, 5000, 250.0", "1000, 5000, 500.0", "2000, 0, 0.0", "1000, 1500, 150.0"
    })
    @DisplayName("수익률 계산 다양한 케이스 테스트")
    void calculateRevenueRate(int investedAmount, long totalEarnings, double expectedRevenueRate) {
        RevenueCalculator calculator = new RevenueCalculator();
        Money money = new Money(investedAmount);

        double actualRevenueRate = calculator.calculateRevenueRate(totalEarnings, money);

        Assertions.assertThat(actualRevenueRate).isEqualTo(expectedRevenueRate);
    }

}
