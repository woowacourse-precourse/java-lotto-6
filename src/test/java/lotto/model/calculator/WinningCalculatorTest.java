package lotto.model.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

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
        assertThat(winningCalculator.comparingLottoAndWinningNumber(lottoNumber, bonusNumber)).isEqualTo(
                expectedResult);
    }

    static Stream<Arguments> lottoAndBonusNumber() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 1, 1),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 45, 0)
        );
    }

    @Test
    @DisplayName("일치하는 숫자가 3개라면 5등 당첨 수가 증가한다.")
    void fifthPlace() {
        // given
        Integer firstPlace = winningCalculator.countOfPlace(1);
        Integer secondPlace = winningCalculator.countOfPlace(2);
        Integer thirdPlace = winningCalculator.countOfPlace(3);
        Integer fourthPlace = winningCalculator.countOfPlace(4);
        Integer fifthPlace = winningCalculator.countOfPlace(5);

        // when
        winningCalculator.winning(3, 0);

        // then
        assertThat(winningCalculator.countOfPlace(5)).isEqualTo(fifthPlace + 1);
        assertThat(winningCalculator.countOfPlace(4)).isEqualTo(fourthPlace);
        assertThat(winningCalculator.countOfPlace(3)).isEqualTo(thirdPlace);
        assertThat(winningCalculator.countOfPlace(2)).isEqualTo(secondPlace);
        assertThat(winningCalculator.countOfPlace(1)).isEqualTo(firstPlace);
    }

    @Test
    @DisplayName("일치하는 숫자가 4개라면 4등 당첨 수가 증가한다.")
    void fourthPlace() {
        // given
        Integer firstPlace = winningCalculator.countOfPlace(1);
        Integer secondPlace = winningCalculator.countOfPlace(2);
        Integer thirdPlace = winningCalculator.countOfPlace(3);
        Integer fourthPlace = winningCalculator.countOfPlace(4);
        Integer fifthPlace = winningCalculator.countOfPlace(5);

        // when
        winningCalculator.winning(4, 0);

        // then
        assertThat(winningCalculator.countOfPlace(5)).isEqualTo(fifthPlace);
        assertThat(winningCalculator.countOfPlace(4)).isEqualTo(fourthPlace + 1);
        assertThat(winningCalculator.countOfPlace(3)).isEqualTo(thirdPlace);
        assertThat(winningCalculator.countOfPlace(2)).isEqualTo(secondPlace);
        assertThat(winningCalculator.countOfPlace(1)).isEqualTo(firstPlace);
    }

    @Test
    @DisplayName("일치하는 숫자가 5개라면 3등 당첨 수가 증가한다.")
    void thirdPlace() {
        // given
        Integer firstPlace = winningCalculator.countOfPlace(1);
        Integer secondPlace = winningCalculator.countOfPlace(2);
        Integer thirdPlace = winningCalculator.countOfPlace(3);
        Integer fourthPlace = winningCalculator.countOfPlace(4);
        Integer fifthPlace = winningCalculator.countOfPlace(5);

        // when
        winningCalculator.winning(5, 0);

        // then
        assertThat(winningCalculator.countOfPlace(5)).isEqualTo(fifthPlace);
        assertThat(winningCalculator.countOfPlace(4)).isEqualTo(fourthPlace);
        assertThat(winningCalculator.countOfPlace(3)).isEqualTo(thirdPlace + 1);
        assertThat(winningCalculator.countOfPlace(2)).isEqualTo(secondPlace);
        assertThat(winningCalculator.countOfPlace(1)).isEqualTo(firstPlace);
    }

    @Test
    @DisplayName("일치하는 숫자가 5개이고 보너스 볼이 일치하면 2등 당첨 수가 증가한다.")
    void secondPlace() {
        // given
        Integer firstPlace = winningCalculator.countOfPlace(1);
        Integer secondPlace = winningCalculator.countOfPlace(2);
        Integer thirdPlace = winningCalculator.countOfPlace(3);
        Integer fourthPlace = winningCalculator.countOfPlace(4);
        Integer fifthPlace = winningCalculator.countOfPlace(5);

        // when
        winningCalculator.winning(5, 1);

        // then
        assertThat(winningCalculator.countOfPlace(5)).isEqualTo(fifthPlace);
        assertThat(winningCalculator.countOfPlace(4)).isEqualTo(fourthPlace);
        assertThat(winningCalculator.countOfPlace(3)).isEqualTo(thirdPlace);
        assertThat(winningCalculator.countOfPlace(2)).isEqualTo(secondPlace + 1);
        assertThat(winningCalculator.countOfPlace(1)).isEqualTo(firstPlace);
    }

    @Test
    @DisplayName("일치하는 숫자가 6개라면 1등 당첨 수가 증가한다.")
    void firstPlace() {
        // given
        Integer firstPlace = winningCalculator.countOfPlace(1);
        Integer secondPlace = winningCalculator.countOfPlace(2);
        Integer thirdPlace = winningCalculator.countOfPlace(3);
        Integer fourthPlace = winningCalculator.countOfPlace(4);
        Integer fifthPlace = winningCalculator.countOfPlace(5);

        // when
        winningCalculator.winning(6, 0);

        // then
        assertThat(winningCalculator.countOfPlace(5)).isEqualTo(fifthPlace);
        assertThat(winningCalculator.countOfPlace(4)).isEqualTo(fourthPlace);
        assertThat(winningCalculator.countOfPlace(3)).isEqualTo(thirdPlace);
        assertThat(winningCalculator.countOfPlace(2)).isEqualTo(secondPlace);
        assertThat(winningCalculator.countOfPlace(1)).isEqualTo(firstPlace + 1);
    }
}