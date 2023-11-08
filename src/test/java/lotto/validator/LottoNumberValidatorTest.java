package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoNumberValidatorTest {
    @ParameterizedTest
    @DisplayName("범위 내의 숫자는 예외 미발생")
    @ValueSource(strings = {"1", "45", "22"})
    void validateValidRangeInteger(String number) {
        assertDoesNotThrow(() -> LottoNumberValidator.validate(number));
    }

    @ParameterizedTest
    @DisplayName("숫자가 아닐 경우 예외 발생")
    @ValueSource(strings = {"a", "bc"})
    void validatePositiveIntegerThatIsNotMultipleOf1000(String number) {
        assertThatThrownBy(() -> LottoNumberValidator.validate(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("범위 내의 정수가 아닐 경우 예외 발생")
    @ValueSource(strings = {"-1", "-1000", "123"})
    void validateNumberThatIsNotPositiveInteger(String number) {
        assertThatThrownBy(() -> LottoNumberValidator.validate(number)).isInstanceOf(IllegalArgumentException.class);
    }
}
