package lotto.utils;

import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ProfitRateCalculatorTest {

    ProfitRateCalculator profitRateCalculator = new ProfitRateTwoDecimalRoundCalculator();
    LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
    }

    @DisplayName("수익률이 정확히 계산되었는가")
    @ParameterizedTest
    @CsvSource(value = {"8000,62.5"})
    void calculate(int input, double expectedProfitRate) {
        //given
        Money money = new Money(input);
        int invested = money.purchasedMoney();
        lottoResult.putRank(Rank.FIFTH);

        //when
        double profitRate = profitRateCalculator.calculateProfitRate(lottoResult.getTotalProfit(), invested);

        //then
        Assertions.assertThat(profitRate).isEqualTo(expectedProfitRate);
    }

    @DisplayName("수익률이 정확히 계산되었는가")
    @ParameterizedTest
    @CsvSource(value = {"8000,40.3"})
    void calculateWrong(int input, double expectedProfitRate) {
        //given
        Money money = new Money(input);
        int invested = money.purchasedMoney();
        lottoResult.putRank(Rank.FIFTH);

        //when
        double profitRate = profitRateCalculator.calculateProfitRate(lottoResult.getTotalProfit(), invested);

        //then
        Assertions.assertThat(profitRate).isNotEqualTo(expectedProfitRate);
    }

    @DisplayName("소수점 둘째 자리에서 반올림 되지 않는다.")
    @ParameterizedTest
    @CsvSource(value = {"8000,62.54", "8000,40"})
    void notRoundTwoDecimalPoint(int input, double expectedProfitRate) {
        //given
        Money money = new Money(input);
        int invested = money.purchasedMoney();
        lottoResult.putRank(Rank.FIFTH);

        //when
        double profitRate = profitRateCalculator.calculateProfitRate(lottoResult.getTotalProfit(), invested);

        //then
        Assertions.assertThat(profitRate).isNotEqualTo(expectedProfitRate);
    }

}
