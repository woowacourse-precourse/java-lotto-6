package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ProfitRateCalculatorTest {

    @DisplayName("수익률이 정확히 계산되었는가")
    @ParameterizedTest
    @CsvSource(value = {"8000,62.5"})
    void calculate(int money, double expectedProfitRate) {
        ProfitRateCalculator profitRateCalculator = new ProfitRateTwoDecimalRoundCalculator();
        LottoPurchaser lottoPurchaser = new LottoPurchaser(new Money(money));

        int invested = lottoPurchaser.purchaseMoney();

        LottoResult lottoResult = new LottoResult();
        lottoResult.putRank(Rank.FIFTH);

        double profitRate = profitRateCalculator.calcualteProfitRate(lottoResult.getTotalProfit(), invested);
        Assertions.assertThat(profitRate).isEqualTo(expectedProfitRate);
    }

    @DisplayName("수익률이 정확히 계산되었는가")
    @ParameterizedTest
    @CsvSource(value = {"8000,40.3"})
    void calculateWrong(int money, double expectedProfitRate) {
        ProfitRateCalculator profitRateCalculator = new ProfitRateTwoDecimalRoundCalculator();
        LottoPurchaser lottoPurchaser = new LottoPurchaser(new Money(money));

        int invested = lottoPurchaser.purchaseMoney();

        LottoResult lottoResult = new LottoResult();
        lottoResult.putRank(Rank.FIFTH);

        double profitRate = profitRateCalculator.calcualteProfitRate(lottoResult.getTotalProfit(), invested);
        Assertions.assertThat(profitRate).isNotEqualTo(expectedProfitRate);
    }

    @DisplayName("소수점 둘째 자리에서 반올림 되지 않는다.")
    @ParameterizedTest
    @CsvSource(value = {"8000,62.54", "8000,40"})
    void notRoundTwoDecimalPoint(int money, double expectedProfitRate) {
        ProfitRateCalculator profitRateCalculator = new ProfitRateTwoDecimalRoundCalculator();
        LottoPurchaser lottoPurchaser = new LottoPurchaser(new Money(money));

        int invested = lottoPurchaser.purchaseMoney();

        LottoResult lottoResult = new LottoResult();
        lottoResult.putRank(Rank.FIFTH);

        double profitRate = profitRateCalculator.calcualteProfitRate(lottoResult.getTotalProfit(), invested);
        Assertions.assertThat(profitRate).isNotEqualTo(expectedProfitRate);
    }

}
