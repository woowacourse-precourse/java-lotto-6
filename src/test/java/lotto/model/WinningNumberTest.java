package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumberTest {


    @Test
    @DisplayName("1보다 작은 숫자가 포함된 당첨번호는 예외를 던진다.")
    void createWinningNumber_NumberLessThan1_ThrownException() {
        // given
        List<Integer> givenWinningNumbers = List.of(0, 1, 2, 3, 4, 5);
        int bonusNumber = 10;

        // when
        // then
        assertThatThrownBy(() -> new WinningNumber(givenWinningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("45보다 큰 숫자가 포함된 당첨번호는 예외를 던진다.")
    void createWinningNumber_NumberMoreThan45_ThrownException() {
        // given
        List<Integer> givenWinningNumbers = List.of(1, 2, 3, 4, 5, 46);
        int bonusNumber = 10;

        // when
        // then
        assertThatThrownBy(() -> new WinningNumber(givenWinningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또에 필요한 번호 수 보다 적은 수의 당첨번호는 예외를 던진다.")
    void createWinningNumber_WinningNumberSizeLessThan6_ThrownException() {
        // given
        List<Integer> givenWinningNumbers = List.of(1, 2, 3, 4, 5);
        int bonusNumber = 10;

        // when
        // then
        assertThatThrownBy(() -> new WinningNumber(givenWinningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또에 필요한 번호 수 보다 많은 수의 당첨번호는 예외를 던진다.")
    void createWinningNumber_WinningNumberSizeMoreThan6_ThrownException() {
        // given
        List<Integer> givenWinningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        int bonusNumber = 10;

        // when
        // then
        assertThatThrownBy(() -> new WinningNumber(givenWinningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 번호가 포함된 당첨번호는 예외를 던진다.")
    void createWinningNumber_DuplicateWinningNumber_ThrownException() {
        // given
        List<Integer> givenWinningNumbers = List.of(1, 2, 3, 4, 5, 5);
        int bonusNumber = 10;

        // when
        // then
        assertThatThrownBy(() -> new WinningNumber(givenWinningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호와 보너스 번호가 중복되면 예외를 던진다.")
    void createWinningNumber_DuplicateWinningNumberAndBonusNumber_ThrownException() {
        // given
        List<Integer> givenWinningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 1;

        // when
        // then
        assertThatThrownBy(() -> new WinningNumber(givenWinningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("lottoProvider")
    @DisplayName("당첨번호와 보너스 번호를 통해 로또의 결과를 반환해준다.")
    void compareLottoNumbers(List<Integer> lottoNumbers, int expectedCount) {
        // given
        List<Integer> givenWinningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumber winningNumber = new WinningNumber(givenWinningNumbers, bonusNumber);
        Lotto lotto = Lotto.generateLotto(lottoNumbers);

        // when
        int count = winningNumber.countMatchingNumbers(lotto);

        // then
        assertThat(count).isEqualTo(expectedCount);
    }

    private static Stream<Arguments> lottoProvider() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), 6),
                Arguments.of(List.of(11, 12, 13, 14, 15, 16), 0),
                Arguments.of(List.of(1, 2, 3, 4, 15, 16), 4),
                Arguments.of(List.of(1, 2, 3, 4, 7, 16), 5)
        );
    }

}
