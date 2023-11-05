package lotto.validation;

import static lotto.validation.enumType.AmountInput.NUMERIC_FORMAT_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AmountInputValidatorTest {

    @Test
    @DisplayName("입력값이 숫자가 아니면 예외가 발생하는 테스트")
    void testValidateInputNumericFormat() {
        // given
        AmountInputValidator inputValidation = new AmountInputValidator();

        // when
        String input = "one";

        // then
        assertThatThrownBy(() -> inputValidation.validateInputNumericFormat(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMERIC_FORMAT_MESSAGE.getValue());
    }
}