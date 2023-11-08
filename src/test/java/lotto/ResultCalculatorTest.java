package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultCalculatorTest {
    ResultCalculator calculator = new ResultCalculator();

    @Test
    @DisplayName("당첨 결과와 로또 구입 개수를 이용해 수익률을 정확하게 계산한다")
    public void testCalculateEarningsRate() {
        WinningResult result = new WinningResult();
        result.addWinningTicket(3, false);  // Suppose we have one ticket with 3 correct numbers
        int lottoCount = 1;

        double earningsRate = calculator.calculateEarningsRate(result, lottoCount);

        Assertions.assertTrue(earningsRate == 5000.0 / 1000);
    }

    @Test
    @DisplayName("당첨 결과를 이용해 총 상금을 정확하게 계산한다")
    public void testCalculateTotalPrize() {
        WinningResult result = new WinningResult();
        result.addWinningTicket(3, false);  // Suppose we have one ticket with 3 correct numbers

        long totalPrize = calculator.calculateTotalPrize(result);

        Assertions.assertTrue(totalPrize == 5000);
    }

    @Test
    @DisplayName("로또 구입 개수를 이용해 총 투자 금액을 정확하게 계산한다")
    public void testCalculateInvestMoney() {
        int lottoCount = 1;

        long investMoney = calculator.calculateInvestMoney(lottoCount);

        Assertions.assertTrue(investMoney == 1000);
    }
}
