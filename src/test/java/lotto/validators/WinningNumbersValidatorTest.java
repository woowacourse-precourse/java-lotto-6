package lotto.validators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersValidatorTest {

    @DisplayName("당첨 번호의 개수가 총 6개가 아니라면 예외가 발생한다.")
    @Test
    void validateLength() {
        assertThatThrownBy(() -> WinningNumbersValidator.validateLength(List.of("1", "2", "3", "4", "5", "6", "7")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 숫자가 아니라면 예외가 발생한다.")
    @Test
    void validateType() {
        assertThatThrownBy(() -> WinningNumbersValidator.validateType(List.of("1", "2", "3", "a", "5", "6")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 범위가 1이상 45이하가 아니라면 예외가 발생한다.")
    @Test
    void validateRange() {
        assertThatThrownBy(() -> WinningNumbersValidator.validateRange(List.of("1", "2", "3", "54", "5", "6")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void validateDuplicate() {
        assertThatThrownBy(() -> WinningNumbersValidator.validateDuplicate(List.of("1", "2", "3", "3", "5", "6")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}