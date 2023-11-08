package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumValidatorTest {
    @DisplayName("당첨 번호에 정수가 아닌 값이 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByCharacter() {
        final String[] winningNum = { "1", "2", "3", "a", "5", "6" };
        assertThatThrownBy(() -> WinningNumValidator.validate(winningNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningNumberByOverSize() {
        final String[] winningNum = { "1", "2", "3", "4", "5", "6", "7" };
        assertThatThrownBy(() -> WinningNumValidator.validate(winningNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByDuplicatedNumber() {
        final String[] winningNum = { "1", "2", "3", "4", "5", "5" };
        assertThatThrownBy(() -> WinningNumValidator.validate(winningNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1에서 45사이의 수가 아니면 예외가 발생한다.")
    @Test
    void reateWinningNumberByDuplicatedNumber() {
        final String[] winningNum = { "1", "2", "3", "4", "5", "52" };
        assertThatThrownBy(() -> WinningNumValidator.validate(winningNum))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
