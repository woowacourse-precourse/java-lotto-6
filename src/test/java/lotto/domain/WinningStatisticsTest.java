package lotto.domain;

import static lotto.domain.Prize.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningStatisticsTest {


    @ParameterizedTest
    @MethodSource("makeStatisticsArguments")
    @DisplayName("구입 금액에 맞게 알맞은 통계를 생성하는지 테스트")
    void calculateRateOfReturnTest(int purchaseAmount, List<Prize> winningPrizes, double rateOfReturn) {
        WinningStatistics winningStatistics = new WinningStatistics();
        winningStatistics.acceptWinPrizes(winningPrizes);
        assertThat(winningStatistics.calculateRateOfReturn(purchaseAmount)).contains(
                String.valueOf(Math.round(rateOfReturn * 10.0) / 10.0));
    }

    private static Stream<Arguments> makeStatisticsArguments() {
        return Stream.of(
                Arguments.of(1000, List.of(ONE), 0),
                Arguments.of(2000, List.of(ONE, TWO), 0),
                Arguments.of(3000, List.of(ONE, TWO, THREE), (double) 5000 / 3000 * 100),
                Arguments.of(4000, List.of(ONE, TWO, THREE, FOUR), (double) 55000 / 4000 * 100),
                Arguments.of(5000, List.of(ONE, TWO, THREE, FOUR, FIVE), (double) 1555000 / 5000 * 100),
                Arguments.of(6000, List.of(ONE, TWO, THREE, FOUR, FIVE, FIVE_BONUS), (double) 31555000 / 6000 * 100),
                Arguments.of(6000, List.of(ONE, TWO, THREE, FOUR, FIVE, SIX), (double) 201555000 / 6000 * 100)
        );
    }
}