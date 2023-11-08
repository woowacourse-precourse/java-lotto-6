package lotto.domain;

import lotto.domain.wrapper.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoResultTest {

    private static Stream<Arguments> checkProfit() {
        return Stream.of(
                Arguments.of(Map.of(
                        LottoHandler.SIX, 1,
                        LottoHandler.FIVE_WITH_BONUS, 1,
                        LottoHandler.FIVE, 1,
                        LottoHandler.FOUR, 0,
                        LottoHandler.THREE, 0,
                        LottoHandler.OTHER, 4
                ), 29021428.6),
                Arguments.of(Map.of(
                        LottoHandler.SIX, 0,
                        LottoHandler.FIVE_WITH_BONUS, 1,
                        LottoHandler.FIVE, 0,
                        LottoHandler.FOUR, 0,
                        LottoHandler.THREE, 1,
                        LottoHandler.OTHER, 5
                ), 428642.9)
        );
    }

    @DisplayName("수익률을 정상적으로 반환한다.")
    @ParameterizedTest(name = "[{index}] input {0} ")
    @MethodSource("checkProfit")
    void createProfit(Map<LottoHandler, Integer> lottoResult, double expectedProfit) {
        LottoResult lottoResults = LottoResult.create(lottoResult);
        BigDecimal actualValue = new BigDecimal(Double.toString(lottoResults.getProfit()));
        BigDecimal expectedValue = new BigDecimal(expectedProfit);

        assertThat(actualValue.setScale(1, RoundingMode.HALF_UP)).isEqualTo(expectedValue.setScale(1, RoundingMode.HALF_UP));
    }
}
