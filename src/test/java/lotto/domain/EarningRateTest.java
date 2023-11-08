package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class EarningRateTest {

    @DisplayName("EarningRate ToString() 출력")
    @ParameterizedTest
    @CsvSource(value = {"9000,90", "8000,80", "3000,30", "1000,10"})
    public void earningRate_toString(int prizeAmount, int percentage) {

        //given
        PurchaseBudget purchaseBudget = new PurchaseBudget(10000);
        TotalPrizeAmount totalPrizeAmount = new TotalPrizeAmount(prizeAmount);
        WinnerStatistics winnerStatistics = new WinnerStatistics(null, totalPrizeAmount);

        //when
        EarningRate earningRate = EarningRate.of(purchaseBudget, winnerStatistics);

        //then
        assertThat(earningRate.toString()).isEqualTo("총 수익률은 " + percentage + "%%입니다.", percentage);
    }
}
