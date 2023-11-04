package lotto.domain.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @DisplayName("공백이나 빈값이 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    void validateExistValue(String whiteSpace) {
        assertThatThrownBy(() -> Validator.validateExistValue(whiteSpace))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("맨 앞자리가 0으로 시작하거나 숫자가 아닌 값이 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "원", "1000d"})
    void validateNumericInput(String notNumber) {
        assertThatThrownBy(() -> Validator.validateNumericInput(notNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000으로 나눠지지 않는 숫자가 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 21, 132, 1001, 20002})
    void validateDivisibleBy1000(int indivisible) {
        assertThatThrownBy(() -> Validator.validateDivisibleBy1000(indivisible))
                .isInstanceOf(IllegalArgumentException.class);
    }
}