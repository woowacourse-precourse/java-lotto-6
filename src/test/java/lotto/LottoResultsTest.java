package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultsTest {

    @ParameterizedTest(name = "{0}이 당첨되면 당첨 금액은 {1}이다.")
    @MethodSource("listAndBigDecimalProvider")
    @DisplayName("최종 금액을 구하는데 성공한다.")
    void test_Sum(List<LottoResult> results, BigDecimal expectedSum) {
        //given
        LottoResults lottoResults = LottoResults.of(results);

        //when
        BigDecimal sum = lottoResults.sum();

        //then
        assertThat(sum).isEqualTo(expectedSum);
    }

    static Stream<Arguments> listAndBigDecimalProvider() {
        return Stream.of(
                Arguments.of(List.of(LottoResult.SIX_MATCHING, LottoResult.FOUR_MATCHING), new BigDecimal(30050000)),
                Arguments.of(List.of(LottoResult.THREE_MATCHING, LottoResult.THREE_MATCHING), new BigDecimal(10000)),
                Arguments.of(List.of(LottoResult.NO_MATCHING, LottoResult.NO_MATCHING), BigDecimal.ZERO),
                Arguments.of(
                        List.of(LottoResult.NO_MATCHING, LottoResult.NO_MATCHING, LottoResult.THREE_MATCHING),
                        new BigDecimal(5000)
                ),
                Arguments.of(
                        List.of(
                                LottoResult.FIVE_MATCHING,
                                LottoResult.FOUR_MATCHING,
                                LottoResult.FOUR_MATCHING,
                                LottoResult.THREE_MATCHING
                        ),
                        new BigDecimal(1605000)
                )
        );
    }

}
