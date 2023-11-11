package lotto.model;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {
    private final static int PRICE_OF_LOTTO = 1000;

    @DisplayName("로또의 총 수익률을 계산")
    @ParameterizedTest
    @MethodSource("calculateTotalProfitTestCases")
    void calculateTotalProfitTest(List<Ranking> rankings) {
        // given
        Result result = new Result(rankings);
        // when
        double totalProfit = result.getTotalProfit();
        double expectedTotalProfit =
                (rankings.stream().mapToDouble(Ranking::getProfit).sum() / (rankings.size() * PRICE_OF_LOTTO)) * 100;
        // then
        Assertions.assertThat(String.format("%.1f", totalProfit)).isEqualTo(String.format("%.1f", expectedTotalProfit));
    }

    static Stream<Arguments> calculateTotalProfitTestCases() {
        return Stream.of(
                Arguments.of(List.of(Ranking.FIRST, Ranking.SECOND, Ranking.THIRD)),
                Arguments.of(List.of(Ranking.FIRST, Ranking.SECOND)),
                Arguments.of(List.of(Ranking.FIRST, Ranking.FAIL, Ranking.THIRD)),
                Arguments.of(List.of(Ranking.FAIL, Ranking.FAIL, Ranking.THIRD))
        );
    }
}