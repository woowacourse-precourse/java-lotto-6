package lotto.model.calculator;

import static lotto.util.ExceptionMessage.INVALID_AMOUNT_OF_INVESTMENT;
import static lotto.util.ExceptionMessage.INVALID_RATE_OF_RESULT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
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

    @ParameterizedTest
    @CsvSource({
            "1000, 5000, 500",
            "8000, 5000, 62.5"
    })
    @DisplayName("당첨금 / 투자 금액을 소수점 둘째 자리에서 반올림하여 반환한다.")
    void returnRateOfReturn(Integer amountOfInvestment, Long totalPrizeMoney, Double expectedRateOfReturn) {
        // given
        // when & then
        assertThat(winningCalculator.calculateRateOfReturn(amountOfInvestment, totalPrizeMoney)).isEqualTo(
                expectedRateOfReturn);
    }

    @ParameterizedTest
    @CsvSource({
            "1000, 0, 0",
            "1000, 2000000000, 200000000"
    })
    @DisplayName("수익률이 0% 이상 2000000%이하라면 어떠한 Exception도 감지되지 않는다.")
    void supportedRateOfResult(Integer amountOfInvestment, Long totalPrizeMoney, Double expectedRateOfReturn) {
        // given
        // when & then
        assertThatNoException().isThrownBy(() -> winningCalculator.calculateRateOfReturn(amountOfInvestment, totalPrizeMoney));
        assertThat(winningCalculator.calculateRateOfReturn(amountOfInvestment, totalPrizeMoney)).isEqualTo(
                expectedRateOfReturn);
    }

    @ParameterizedTest
    @CsvSource({
            "1000, -2000",
            "1000, 4000000000"
    })
    @DisplayName("수익률이 0% 미만 2000000% 초과라면 IllegalArgumentException을 반환한다.")
    void notSupportedRateOfResult(Integer amountOfInvestment, Long totalPrizeMoney) {
        // given
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> winningCalculator.calculateRateOfReturn(amountOfInvestment, totalPrizeMoney))
                .withMessage(INVALID_RATE_OF_RESULT.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "0, 5000"
    })
    @DisplayName("투자 금액이 0원이면 IllegalArgumentException을 반환한다.")
    void divideByZeroTest(Integer amountOfInvestment, Long totalPrizeMoney) {
        // given
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> winningCalculator.calculateRateOfReturn(amountOfInvestment, totalPrizeMoney))
                .withMessage(INVALID_AMOUNT_OF_INVESTMENT.getMessage());
    }
}