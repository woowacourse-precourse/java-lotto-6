package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {

    @DisplayName("유효한 당첨 번호와 보너스 번호로 WinningLotto 객체를 생성할 수 있다.")
    @ParameterizedTest(name = "[{index}] 유효한 값: {arguments}")
    @MethodSource("validWinningNumbersAndBonusNumber")
    void givenValidWinningNumbersAndBonusNumber_whenCreatingWinningLotto_thenNoException(
            List<Integer> winningNumbers, int bonusNumber) {
        // When
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        // Then
        assertThat(winningLotto.getWinningNumbers()).containsExactlyElementsOf(winningNumbers);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(bonusNumber);
    }

    static Stream<Arguments> validWinningNumbersAndBonusNumber() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7),
                Arguments.of(List.of(8, 9, 10, 11, 12, 13), 14)
        );
    }

    @DisplayName("유효하지 않은 당첨 번호나 보너스 번호가 주어지면 예외가 발생해야 한다.")
    @ParameterizedTest
    @MethodSource("invalidWinningNumbersAndBonusNumber")
    void givenInvalidWinningNumbersOrBonusNumber_whenCreatingWinningLotto_thenExceptionIsThrown(
            List<Integer> winningNumbers, int bonusNumber) {
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> invalidWinningNumbersAndBonusNumber() {
        return Stream.of(
                // 유효하지 않은 크기
                Arguments.of(List.of(1, 2, 3, 4, 5), 7),
                // 범위를 벗어난 숫자 포함
                Arguments.of(List.of(1, 2, 3, 4, 5, 51), 7),
                // 유효하지 않은 보너스 번호
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 49)
        );
    }
}
