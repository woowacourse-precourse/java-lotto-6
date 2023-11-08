package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PrizeSummaryTest {

    @ParameterizedTest
    @MethodSource("providePrizeSummaryAndInvestmentForTotalProfitRate")
    void 당첨내역의_총_금액과_투자_금액으로_수익률을_구할_수_있다(PrizeSummary prizeSummary, int investment,
                                          double expectedProfitRate) {
        InvestmentMoney investmentMoney = InvestmentMoney.from(investment);

        TotalProfitRate actualTotalProfitRate = prizeSummary.generateTotalProfitRate(investmentMoney);

        TotalProfitRate expectedTotalProfitRate = TotalProfitRate.from(expectedProfitRate);
        assertThat(actualTotalProfitRate).isEqualTo(expectedTotalProfitRate);
    }

    private static Stream<Arguments> providePrizeSummaryAndInvestmentForTotalProfitRate() {
        return Stream.of(
                Arguments.of(PrizeSummary.from(Map.of(LottoPrize.FIFTH_PRIZE, 1L)), 1000, 500.0),
                Arguments.of(PrizeSummary.from(Map.of(LottoPrize.FOURTH_PRIZE, 1L)), 5000, 1_000.0),
                Arguments.of(PrizeSummary.from(Map.of(LottoPrize.THIRD_PRIZE, 1L)), 15000, 10_000.0),
                Arguments.of(PrizeSummary.from(Map.of(LottoPrize.NOTHING, 10L)), 5000, 0.0)
        );
    }
}
