package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoProfitRateCalculatorTest {
    @DisplayName("calculate는 로또 구입 금액과 LottoGrade의 목록을 받아 수익률을 계산한다.")
    @ParameterizedTest
    @MethodSource("getLottoResult")
    void calculate(Map<LottoGrade, Integer> statistics, String expected) {
        // given
        LottoProfitRateCalculator calculator = new LottoProfitRateCalculator();

        // when
        LottoProfitRate profitRate = calculator.calculate(statistics);

        // then
        assertThat(profitRate.getValueByString()).isEqualTo(expected);
    }


    static Stream<Arguments> getLottoResult() {
        return Stream.of(
                Arguments.of(
                        Map.of(LottoGrade.MISS, 5),
                        "0.0"
                ),
                Arguments.of(
                        Map.of(),
                        "0.0"
                ),
                Arguments.of(
                        Map.of(
                                LottoGrade.FIFTH, 1,
                                LottoGrade.MISS, 7
                        ),
                        "62.5"
                )
        );
    }
}