package lotto.validators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersValidatorTest {

    @DisplayName("당첨 번호의 개수가 총 6개가 아니라면 예외가 발생한다.")
    @Test
    void validateLength() {
        assertThatThrownBy(() -> WinningNumbersValidator.validateLength(new String[]{"1","2","3","4","5","6","7"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 숫자가 아니라면 예외가 발생한다.")
    @Test
    void validateType() {
        assertThatThrownBy(() -> WinningNumbersValidator.validateType(new String[]{"1","2","3","a","4","5"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 범위가 1이상 45이하가 아니라면 예외가 발생한다.")
    @Test
    void validateRange() {
        assertThatThrownBy(() -> WinningNumbersValidator.validateRange(new String[]{"1","2","53","4","5","6"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void validateDuplicate() {
        assertThatThrownBy(() -> WinningNumbersValidator.validateDuplicate(new String[]{"1","2","3","3","5","6"}))
                .isInstanceOf(IllegalArgumentException.class);
    }
}