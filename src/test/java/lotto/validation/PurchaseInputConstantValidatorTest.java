package lotto.validation;

import static lotto.validation.constant.PurchaseInputConstant.POSITIVE_MESSAGE;
import static lotto.validation.constant.PurchaseInputConstant.VALUE_DIVIDE_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseInputConstantValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-400"})
    @DisplayName("입력값이 양수가 아니면 예외가 발생하는 테스트")
    void testValidatePositive(String input) {
        PurchaseInputValidator inputValidation = new PurchaseInputValidator();

        assertThatThrownBy(() -> inputValidation.validatePositive(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(POSITIVE_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1500", "157", "999"})
    @DisplayName("입력값이 1000으로 나누어 떨어지지 않으면 예외가 발생하는 테스트")
    void testValidateDivisibilityBy1000(String input) {
        PurchaseInputValidator inputValidation = new PurchaseInputValidator();

        assertThatThrownBy(() -> inputValidation.validateDivisibilityBy1000(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(VALUE_DIVIDE_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "3000", "14000"})
    @DisplayName("구입 금액 입력에 대해 모든 검증을 하여 정상 입력이면 예외가 발생하지 않아야 하는 테스트")
    void testValidateAttemptInput(String input) {
        PurchaseInputValidator inputValidation = new PurchaseInputValidator();

        assertThatCode(() -> inputValidation.validateAmountInput(input))
                .doesNotThrowAnyException();
    }
}