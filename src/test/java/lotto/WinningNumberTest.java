package lotto;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumberTest {

    @DisplayName("당첨 번호에 따른 예외 테스트")
    @ParameterizedTest
    @MethodSource("winningNumber")
    void checkWinningNumber(List<Integer> winningNumbers, String message) {

        Assertions.assertThatThrownBy(() -> WinningNumber.checkWinningNumber(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(message);
    }

    private static Stream<Arguments> winningNumber() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6, 7), "[ERROR] 당첨 번호는 6개를 입력해야 합니다."),
                Arguments.arguments(List.of(1, 1, 2, 3, 4, 5), "[ERROR] 당첨 번호는 서로 다른 번호를 입력해야 합니다."),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 56), "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.")
        );
    }

    @DisplayName("보너스 번호에 따른 예외 테스트")
    @ParameterizedTest
    @MethodSource("bonusNumber")
    void checkBonusNumber(int bonusNumber, String message) {

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        
        Assertions.assertThatThrownBy(() -> WinningNumber.checkBonusNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(message);
    }

    private static Stream<Arguments> bonusNumber() {
        return Stream.of(
                Arguments.arguments(56, "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
                Arguments.arguments(2, "[ERROR] 보너스 번호는 당첨 번호와 다른 숫자여야 합니다.")
        );
    }

    @Test
    void toWinningNumberList() {
    }

    @Test
    void compareToLotto() {
    }
}