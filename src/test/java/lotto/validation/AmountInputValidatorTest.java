package lotto.validation;

import static lotto.validation.enumType.AmountInput.NUMERIC_FORMAT_MESSAGE;
import static lotto.validation.enumType.AmountInput.POSITIVE_MESSAGE;
import static lotto.validation.enumType.AmountInput.VALUE_DIVIDE_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
                .hasMessageContaining(NUMERIC_FORMAT_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-400"})
    @DisplayName("입력값이 양수가 아니면 예외가 발생하는 테스트")
    void testValidatePositive(String input) {
        AmountInputValidator inputValidation = new AmountInputValidator();

        assertThatThrownBy(() -> inputValidation.validatePositive(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(POSITIVE_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1500", "157", "999"})
    @DisplayName("입력값이 1000으로 나누어 떨어지지 않으면 예외가 발생하는 테스트")
    void testValidateDivisibilityBy1000(String input) {
        AmountInputValidator inputValidation = new AmountInputValidator();

        assertThatThrownBy(() -> inputValidation.validateDivisibilityBy1000(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(VALUE_DIVIDE_MESSAGE.getMessage());
    }
}