package lotto.service;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoProfitCalculatorTest {

    @DisplayName("아무것도 당첨되지 않은 경우 수익률은 0.0% 이다.")
    @Test
    void calculateLottoProfit_No_Winning() {
        int purchaseAmount = 5000;
        List<Integer> lottoResult = List.of(0, 0, 0, 0, 0, 0);

        double profit = LottoProfitCalculator.calculateLottoProfit(purchaseAmount, lottoResult);
        assertThat(profit).isEqualTo(0.0);
    }

    @DisplayName("7,000원으로 5등이 1개 당첨된 경우 수익률은 71.4% 이다.")
    @Test
    void calculateLottoProfit_Fifth_Prize_One() {
        int purchaseAmount = 7000;
        List<Integer> lottoResult = List.of(0, 0, 0, 0, 0, 1);

        double profit = LottoProfitCalculator.calculateLottoProfit(purchaseAmount, lottoResult);
        assertThat(profit).isEqualTo(71.4);
    }

    @DisplayName("7,000원으로 1등이 1개 당첨된 경우 수익률은 28,571,428.6% 이다.")
    @Test
    void calculateLottoProfit_First_Prize_One() {
        int purchaseAmount = 7000;
        List<Integer> lottoResult = List.of(0, 1, 0, 0, 0, 0);

        double profit = LottoProfitCalculator.calculateLottoProfit(purchaseAmount, lottoResult);
        assertThat(profit).isEqualTo(28571428.6);
    }

    @DisplayName("7,000원으로 1등부터 5등까지 1개씩 당첨된 경우 수익률은 29,022,214.3% 이다.")
    @Test
    void calculateLottoProfit_First_To_Fifth_One_Each() {
        int purchaseAmount = 7000;
        List<Integer> lottoResult = List.of(0, 1, 1, 1, 1, 1);

        double profit = LottoProfitCalculator.calculateLottoProfit(purchaseAmount, lottoResult);
        assertThat(profit).isEqualTo(29022214.3);
    }

}