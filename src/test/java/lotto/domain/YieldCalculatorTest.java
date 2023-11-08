package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class YieldCalculatorTest {

    private static final String DAEBAK_RATE = "200,000,000.0%";

    @DisplayName("당첨 결과를 통해 수익률을 구할 수 있다.")
    @ParameterizedTest
    @MethodSource("provideWinningResultAndPurchaseAmount")
    void createYield(Map<Rankings,Integer> result, int purchaseAmount) {
        YieldCalculator yieldCalculator = new YieldCalculator(result, purchaseAmount);

        assertThat(yieldCalculator.getYield()).isEqualTo(DAEBAK_RATE);
    }

    static Stream<Arguments> provideWinningResultAndPurchaseAmount() {
        return Stream.of(
                Arguments.of(
                        Map.of(
                                Rankings.FIRST_PLACE, 1,
                                Rankings.SECOND_PLACE,0,
                                Rankings.THIRD_PLACE, 0,
                                Rankings.FOURTH_PLACE, 0,
                                Rankings.FIFTH_PLACE, 0),
                        1000
                )
        );
    }
}