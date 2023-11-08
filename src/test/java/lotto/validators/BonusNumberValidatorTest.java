package lotto.validators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberValidatorTest {

    @DisplayName("보너스 번호가 숫자가 아니라면 예외가 발생한다.")
    @Test
    void validateType() {
        assertThatThrownBy(() -> BonusNumberValidator.validateType("asd"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 범위가 1이상 45이하가 아니라면 예외가 발생한다.")
    @Test
    void validateRange() {
        assertThatThrownBy(() -> BonusNumberValidator.validateRange("100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 동일하다면 예외가 발생한다.")
    @Test
    void validateDuplicate() {
        assertThatThrownBy(() -> BonusNumberValidator.validateDuplicate("5", new String[]{"1","2","3","4","5","6"}))
                .isInstanceOf(IllegalArgumentException.class);
    }
}