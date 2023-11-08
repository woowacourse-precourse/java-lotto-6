package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator();

    @DisplayName("입력값으로 문자가 입력되면 예외가 발생한다.")
    @ValueSource(strings = {"string", "a", "/", "문자열"})
    @ParameterizedTest
    void isNotDigit1(String input) {
        assertThatThrownBy(() -> inputValidator.validateIsDigit(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값에 문자가 포함되면 예외가 발생한다.")
    @ValueSource(strings = {"5000j", "1.", "%1234", "1/23"})
    @ParameterizedTest
    void isNotDigit2(String input) {
        assertThatThrownBy(() -> inputValidator.validateIsDigit(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 콤마로 구분되어 있지 않으면 예외가 발생한다.")

    void isNotSplitComma(String input) {
        assertThatThrownBy(() -> inputValidator.validateIsSplitByCommaAndDigit(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 콤마로 구분되어 있으나 숫자가 아닌 경우 예외가 발생한다.")
    @ValueSource(strings = {"1,2,3,4,5,a", "a,1,2,3,4,5"})
    @ParameterizedTest
    void isSplitCommaButNotDigit(String input) {
        assertThatThrownBy(() -> inputValidator.validateIsSplitByCommaAndDigit(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}