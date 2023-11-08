package lotto.validator;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PurchaseAmountValidatorTest {

    @ParameterizedTest
    @DisplayName("1000으로 나누어 떨어지는 자연수의 경우 예외 미발생")
    @ValueSource(strings = {"1000", "8000", "100000"})
    void validatePositiveIntegerThatIsMultipleOf1000(String amount) {
        assertDoesNotThrow(() -> PurchaseAmountValidator.validate(amount));
    }

    @ParameterizedTest
    @DisplayName("1000으로 나누어 떨어지지 않는 숫자의 경우 예외 발생")
    @ValueSource(strings = {"1500", "100", "100027"})
    void validatePositiveIntegerThatIsNotMultipleOf1000(String amount) {
        assertThatThrownBy(() -> PurchaseAmountValidator.validate(amount)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("자연수가 아닌 경우 예외 발생")
    @ValueSource(strings = {"0", "-1000", "-123"})
    void validateNumberThatIsNotPositiveInteger(String amount) {
        assertThatThrownBy(() -> PurchaseAmountValidator.validate(amount)).isInstanceOf(IllegalArgumentException.class);
    }
}
