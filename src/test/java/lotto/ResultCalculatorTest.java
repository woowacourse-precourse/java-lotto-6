package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultCalculatorTest {
    ResultCalculator calculator = new ResultCalculator();

    @Test
    @DisplayName("당첨 결과와 로또 구입 개수를 이용해 수익률을 정확하게 계산한다")
    public void testCalculateEarningsRate() {
        // Prepare data
        WinningResult result = new WinningResult();
        result.addWinningTicket(3, false);  // Suppose we have one ticket with 3 correct numbers
        int lottoCount = 1;

        // Call method
        double earningsRate = calculator.calculateEarningsRate(result, lottoCount);

        // Check result
        Assertions.assertTrue(earningsRate == 5000.0 / 1000);
    }
}
