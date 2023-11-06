package lotto.validation;

import static lotto.validation.constant.AmountInput.NUMERIC_FORMAT_MESSAGE;
import static lotto.validation.constant.AmountInput.POSITIVE_MESSAGE;
import static lotto.validation.constant.AmountInput.VALUE_DIVIDE_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AmountInputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"포비", "b ", "10e"})
    @DisplayName("입력값이 숫자가 아니면 예외가 발생하는 테스트")
    void testValidateInputNumericFormat(String input) {
        AmountInputValidator inputValidation = new AmountInputValidator();

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

    @ParameterizedTest
    @ValueSource(strings = {"1000", "3000", "14000"})
    @DisplayName("구입 금액 입력에 대해 모든 검증을 하여 정상 입력이면 예외가 발생하지 않아야 하는 테스트")
    void testValidateAttemptInput(String input) {
        AmountInputValidator inputValidation = new AmountInputValidator();

        assertThatCode(() -> inputValidation.validateAmountInput(input))
                .doesNotThrowAnyException();
    }
}