package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoPrizeBreakdownTest {

    @DisplayName("당첨 내역과 구매 금액을 가지고 수익률을 계산한다.")
    @ParameterizedTest
    @MethodSource("provideLottoRankWithRateOfReturn")
    void shouldCalculateRateOfReturnWhenPrizeBreakdownWithMoney(
            Money money,
            LottoRank rank,
            int winCount,
            String expectedRate
    ) {
        //given
        Map<LottoRank, Integer> prizeDetails = Map.of(rank, winCount);
        LottoPrizeBreakdown result = new LottoPrizeBreakdown(prizeDetails);

        //when
        RateOfReturn rateOfReturn = result.getRateOfReturn(money);

        //then
        assertThat(rateOfReturn.value()).isEqualTo(new BigDecimal(expectedRate));
    }

    private static Stream<Arguments> provideLottoRankWithRateOfReturn() {
        return Stream.of(
                Arguments.of(new Money("5000"), LottoRank.FIFTH_PRIZE, 1, "100.0"),
                Arguments.of(new Money("8000"), LottoRank.FIFTH_PRIZE, 1, "62.5"),
                Arguments.of(new Money("97000"), LottoRank.FIRST_PRIZE, 1, "2061855.7"),
                Arguments.of(new Money("97000"), LottoRank.FOURTH_PRIZE, 1, "51.5"),
                Arguments.of(new Money("100000"), LottoRank.FIRST_PRIZE, 100, "200000000.0")
        );
    }
}