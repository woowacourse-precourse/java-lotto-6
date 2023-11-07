package lotto.utils;

import static lotto.enums.ExceptionMessageType.NUMBER_NOT_INTEGER;
import static lotto.enums.ExceptionMessageType.PAYMENT_NOT_NATURAL_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @DisplayName("정수가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0.0", "1.23", "ab1", ""})
    void testValidateInteger(String input) {
        assertThatThrownBy(() -> InputValidator.validateInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_NOT_INTEGER.getMessage());
    }

    @DisplayName("구입 금액이 0보다 크지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -123})
    void testValidateNaturalNumber(int input) {
        assertThatThrownBy(() -> InputValidator.validateNaturalNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PAYMENT_NOT_NATURAL_NUMBER.getMessage());
    }
}