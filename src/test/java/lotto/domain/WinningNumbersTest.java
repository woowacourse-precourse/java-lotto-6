package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {
    @Test
    @DisplayName("입력된 로또 당첨 번호를 정확히 생성해내는지 테스트")
    void constructorShouldSetWinningNumbers() {
        // Given
        String input = "1, 2, 3, 4, 5, 6";

        // When
        WinningNumbers winningNumbers = new WinningNumbers(input);

        // Then
        assertThat(winningNumbers.getWinningNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("잘못된 형식으로 입력하면 예외가 발생하는지 테스트")
    void constructorShouldThrowExceptionForIncorrectFormat() {
        // Given
        String input = ",1, 2, 3, 4, 5, 6,";

        // Then
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 올바른 입력 형식이 아닙니다.");
    }

    @Test
    @DisplayName("로또 번호가 6개가 아닐 경우 테스트")
    void constructorShouldThrowExceptionForWrongNumberOfWinningNumbers() {
        // Given
        String input = "1, 2, 3, 4, 5";

        // Then
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호가 6개가 아닙니다.");
    }

    @Test
    @DisplayName("중복된 숫자가 있는 경우 테스트")
    void constructorShouldThrowExceptionForDuplicatedWinningNumbers() {
        // Given
        String input = "1, 2, 3, 4, 4, 6";

        // Then
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 숫자가 존재합니다.");
    }

    @Test
    @DisplayName("잘못된 범위에 있는 숫자가 존재할 경우 테스트")
    void constructorShouldThrowExceptionForNumbersOutOfRange() {
        // Given
        String input = "0, 2, 3, 4, 5, 46";

        // Then
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 숫자 범위는 1 ~ 45 입니다.");
    }
}
