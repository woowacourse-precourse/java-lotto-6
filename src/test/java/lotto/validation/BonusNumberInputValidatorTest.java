package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberInputValidatorTest {
    @DisplayName("보너스 번호 입력값이 숫자가 아닌 경우 예외 발생")
    @Test
    void validate_IsNumeric_ExceptionThrown() {
        assertThatThrownBy(() -> BonusNumberInputValidator.validate("abc", Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력값이 1~45 아닌 경우 예외 발생")
    @Test
    void validate_IsInRange_ExceptionThrown() {
        assertThatThrownBy(() -> BonusNumberInputValidator.validate("50", Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 당첨번호에 값 중 하나랑 중복된 경우 예외가 발생")
    @Test
    void validate_IsNotDuplicate_ExceptionThrown() {
        assertThatThrownBy(() -> BonusNumberInputValidator.validate("5", Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
