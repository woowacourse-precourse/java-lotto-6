package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.validator.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    @DisplayName("입력 값이 숫자가 아니면 예외가 발생한다")
    @Test
    void createNotDigit() {
        assertThatThrownBy(() -> InputValidator.validateNumber("12e"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자만 입력하세요");
    }

    @DisplayName("입력 값이 숫자와 쉼표로만 되어 있지 않으면 예외가 발생한다")
    @Test
    void createNotDigitComma() {
        assertThatThrownBy(() -> InputValidator.validateInputRequirement("1,2,,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자와 쉼표(,)만 입력하세요");
    }
}
