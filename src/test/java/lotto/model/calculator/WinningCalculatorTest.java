package lotto.model.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningCalculatorTest {
    WinningCalculator winningCalculator;

    @BeforeEach
    void beforeEach() {
        winningCalculator = new WinningCalculator();
    }

    @ParameterizedTest
    @MethodSource("lottoAndWinningNumber")
    @DisplayName("당첨 번호와 로또 번호를 비교하여 일치한 숫자의 개수를 반환한다.")
    void compareLottoNumberAndWinningNumber(List<Integer> lottoNumber, List<Integer> winningNumber,
                                            int expectedResult) {
        // given
        // when & then
        assertThat(winningCalculator.comparingLottoAndWinningNumber(lottoNumber, winningNumber)).isEqualTo(
                expectedResult);
    }

    static Stream<Arguments> lottoAndWinningNumber() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 45, 44, 43, 42, 41), 1),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 44, 43, 42, 41), 2),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 43, 42, 41), 3),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 42, 41), 4),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 41), 5),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6), 6)
        );
    }

    @ParameterizedTest
    @MethodSource("lottoAndBonusNumber")
    @DisplayName("보너스 번호와 로또 번호를 비교하여 일치한 숫자의 개수를 반환한다.")
    void compareBonusNumberAndWinningNumber(List<Integer> lottoNumber, Integer bonusNumber, int expectedResult) {
        // given
        // when & then
        assertThat(winningCalculator.comparingBonusAndWinningNumber(lottoNumber, bonusNumber)).isEqualTo(
                expectedResult);
    }

    static Stream<Arguments> lottoAndBonusNumber() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 1, 1),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 45, 0)
        );
    }
}