package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator();

    @DisplayName("입력값으로 문자가 입력되면 예외가 발생한다.")
    @Test
    void isNotDigit1() {
        String input = "string";
        assertThatThrownBy(() -> inputValidator.validateIsDigit(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값에 문자가 포함되면 예외가 발생한다.")
    @Test
    void isNotDigit2() {
        String input = "5000j";
        assertThatThrownBy(() -> inputValidator.validateIsDigit(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값이 콤마로 구분되어 있지 않으면 예외가 발생한다.")
    void isNotSplitComma() {
        String input = "1,2,3,4,5.6";
        assertThatThrownBy(() -> inputValidator.validateIsSplitByCommaAndDigit(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값이 콤마로 구분되어 있으나 숫자가 아닌 경우 예외가 발생한다.")
    void isSplitCommaButNotDigit() {
        String input = "1,2,3,4,5,a";
        assertThatThrownBy(() -> inputValidator.validateIsSplitByCommaAndDigit(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}