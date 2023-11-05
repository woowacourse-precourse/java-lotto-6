package lotto.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.FinalGrade;
import lotto.domain.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class YieldCalculatorTest {

    YieldCalculator yieldCalculator = new YieldCalculator();


    @Test
    @DisplayName("7개의 로또 중 1개만 5등한 수익률은 71.4% 이다.")
    void sevenLottoSingleTimeFifth() {
        // given
        FinalGrade finalGrade = new FinalGrade(
                List.of(Rank.FIFTH, Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE,
                        Rank.NONE));
        BigDecimal expectedYield = new BigDecimal("71.4");
        // when
        BigDecimal resultYield = yieldCalculator.calculate(finalGrade);
        // then
        Assertions.assertThat(resultYield).isEqualTo(expectedYield);
    }

    @Test
    @DisplayName("8개의 로또 중 1개만 5등한 수익률은 62.5% 이다.")
    void eightLottoSingleTimeFifth() {
        // given
        FinalGrade finalGrade = new FinalGrade(
                List.of(Rank.FIFTH, Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE));
        BigDecimal expectedYield = new BigDecimal("62.5");
        // when
        BigDecimal resultYield = yieldCalculator.calculate(finalGrade);
        // then
        Assertions.assertThat(resultYield).isEqualTo(expectedYield);
    }

    @Test
    @DisplayName("9개의 로또 중 1개만 5등한 수익률은 55.6% 이다.")
    void nineLottoSingleTimeFifth() {
        // given
        FinalGrade finalGrade = new FinalGrade(
                List.of(Rank.FIFTH, Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE,
                        Rank.NONE, Rank.NONE, Rank.NONE));
        BigDecimal expectedYield = new BigDecimal("55.6");
        // when
        BigDecimal resultYield = yieldCalculator.calculate(finalGrade);
        // then
        Assertions.assertThat(resultYield).isEqualTo(expectedYield);
    }

    @Test
    @DisplayName("1개의 로또 중 1개만 1등한 수익률은 200000000.0% 이다.")
    void oneLottoSingleTimeFirst() {
        // given
        FinalGrade finalGrade = new FinalGrade(List.of(Rank.FIRST));
        BigDecimal expectedYield = new BigDecimal("200000000.0");
        // when
        BigDecimal resultYield = yieldCalculator.calculate(finalGrade);
        // then
        Assertions.assertThat(resultYield).isEqualTo(expectedYield);
    }

    @Test
    @DisplayName("3개의 로또 중 1등, 2등, 3등을 각각 1번씩한 수익률은 67716666.7% 이다.")
    void threeLottoSingleTimeEachFirstSecondThird() {
        // given
        FinalGrade finalGrade = new FinalGrade(List.of(Rank.THIRD, Rank.SECOND, Rank.FIRST));
        BigDecimal expectedYield = new BigDecimal("67716666.7");
        // when
        BigDecimal resultYield = yieldCalculator.calculate(finalGrade);
        // then
        Assertions.assertThat(resultYield).isEqualTo(expectedYield);
    }

    @Test
    @DisplayName("4개의 로또 중 1등, 2등, 3등을 각각 1번씩한 수익률은 50787500.0% 이다.")
    void fourLottoSingleTimeEachFirstSecondThird() {
        // given
        FinalGrade finalGrade = new FinalGrade(List.of(Rank.THIRD, Rank.SECOND, Rank.FIRST, Rank.NONE));
        BigDecimal expectedYield = new BigDecimal("50787500.0");
        // when
        BigDecimal resultYield = yieldCalculator.calculate(finalGrade);
        // then
        Assertions.assertThat(resultYield).isEqualTo(expectedYield);
    }

    @Test
    @DisplayName("1~5등을 한 번도 못한 경우 수익률은 0.0% 이다.")
    void zeroYieldTest() {
        // given
        FinalGrade finalGrade = new FinalGrade(List.of(Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE));
        BigDecimal expectedYield = new BigDecimal("0.0");
        // when
        BigDecimal resultYield = yieldCalculator.calculate(finalGrade);
        // then
        Assertions.assertThat(resultYield).isEqualTo(expectedYield);
    }

    @ParameterizedTest
    @MethodSource("makeTenTimeNonesAndAdditionalRank")
    @DisplayName("꼴등을 10번 하고 1~5등을 1번씩 했을 때의 각 수익률")
    void yieldTest9(List<Rank> playerResults, String expectedYieldInput) {
        FinalGrade finalGrade = new FinalGrade(playerResults);
        BigDecimal expectedYield = new BigDecimal(expectedYieldInput);
        BigDecimal resultYield = yieldCalculator.calculate(finalGrade);

        Assertions.assertThat(resultYield).isEqualTo(expectedYield);
    }

    /*
     * test data:
     * 1) Rank.FIRST: 10_000_000
     * 2) totalPrize: 20_000_000_000_000_000
     * success
     *
     * test data:
     * 1) Rank.FIRST: 100_000_000
     * 2) totalPrize: 200_000_000_000_000_000
     * Heap Memory Leak
     *
     * result: Big Decimal 오버 플로우 발생 전에 메모리 릭 먼저 발생
     */
    @Test
    @DisplayName("수익률 계산 중 오버 플로우, 허용 가능치 스트레스 테스트")
    void bigValueTest() {
        // given
        List<Rank> ranks = createLargeAmountRanks();
        FinalGrade finalGrade = new FinalGrade(ranks);
        BigDecimal expectedTotalPrize = new BigDecimal("20000000000000000");
        BigDecimal expectedTotalYield = new BigDecimal("200000000.0");
        // when
        BigDecimal resultTotalPrize = finalGrade.getPlayerTotalPrize();
        BigDecimal resultTotalYield = yieldCalculator.calculate(finalGrade);
        // then
        Assertions.assertThat(resultTotalPrize).isEqualTo(expectedTotalPrize);
        Assertions.assertThat(resultTotalYield).isEqualTo(expectedTotalYield);
    }

    private List<Rank> createLargeAmountRanks() {
        int total = 10000000;
        List<Rank> ranks = new ArrayList<>();
        for (int count = 0; count < total; count++) {
            ranks.add(Rank.FIRST);
        }
        return ranks;
    }

    private static Stream<Arguments> makeTenTimeNonesAndAdditionalRank() {
        return Stream.of(
                Arguments.of(List.of(Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE,
                        Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE, Rank.FIFTH), "45.5"),

                Arguments.of(List.of(Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE,
                        Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE, Rank.FOURTH), "454.5"),

                Arguments.of(List.of(Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE,
                        Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE, Rank.THIRD), "13636.4"),

                Arguments.of(List.of(Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE,
                        Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE, Rank.SECOND), "272727.3"),

                Arguments.of(List.of(Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE,
                        Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE, Rank.FIRST), "18181818.2")
        );
    }
}