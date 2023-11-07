package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class WinningNumberTest {

    @DisplayName("당첨 번호가 1~45의 숫자가 아니면 IllegalArgumentException 예외처리 검증")
    @ParameterizedTest
    @ValueSource(strings = {"0", "0", "46", "47", "48"})
    void validateWinningNumberRange(String winningNumberInput) {
        assertThatThrownBy(() -> WinningNumber.from(winningNumberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 1~45의 숫자여야 합니다.");
    }

}