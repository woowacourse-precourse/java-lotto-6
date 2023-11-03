package lotto.service;

import lotto.model.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static lotto.model.LottoPrize.DEFAULT;
import static lotto.model.LottoPrize.FIVE_MATCH;
import static lotto.model.LottoPrize.FIVE_WITH_BONUS;
import static lotto.model.LottoPrize.FOUR_MATCH;
import static lotto.model.LottoPrize.SIX_MATCH;
import static lotto.model.LottoPrize.THREE_MATCH;
import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    //TODO: 테스트를 위해서 이렇게 생성해도 될까?
    private final Calculator calculator = new Calculator();

    @DisplayName("로또 수익률 계산")
    @ParameterizedTest(name = "{displayName} prizes: {0}, expected: {1}")
    @MethodSource("totalReturnParametersProvider")
    void checkTotalReturn(List<LottoPrize> prizes, String expected) {
        Double totalReturn = calculator.calculatePrize(prizes);
        assertThat(String.format("%.1f", totalReturn * 100)).isEqualTo(expected);
    }

    static Stream<Arguments> totalReturnParametersProvider() {
        return Stream.of(
                Arguments.of(createLottoPrize(2, THREE_MATCH), "166.7"),
                Arguments.of(createLottoPrize(5), "0.0"),
                Arguments.of(createLottoPrize(4, THREE_MATCH), "100.0"),
                Arguments.of(createLottoPrize(7, THREE_MATCH), "62.5"),
                Arguments.of(createLottoPrize(4, SIX_MATCH), "40000000.0"),
                Arguments.of(createLottoPrize(9, FIVE_MATCH, FIVE_WITH_BONUS), "286363.6"),
                Arguments.of(createLottoPrize(12, THREE_MATCH, FOUR_MATCH), "392.9"),
                Arguments.of(createLottoPrize(0, SIX_MATCH, SIX_MATCH, SIX_MATCH, SIX_MATCH, SIX_MATCH), "200000000.0")
        );
    }

    static List<LottoPrize> createLottoPrize(Integer failCount, LottoPrize... prize) {
        List<LottoPrize> result = new ArrayList<>();
        for (int i = 0; i < failCount; i++) {
            result.add(DEFAULT);
        }
        result.addAll(Arrays.asList(prize));
        return result;
    }
}