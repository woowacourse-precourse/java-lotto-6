package lotto.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumericInputValidationTest {
    private NumericInputValidation numericInputValidation;
    @BeforeEach
    void setUp() {
        numericInputValidation = new NumericInputValidation();
    }
    @DisplayName("아무 입력을 하지않는 경우 에러가 발생한다.")
    @ParameterizedTest
    @NullSource
    @EmptySource
    void enterNothingPurchaseAmount(String input) {
        assertThatThrownBy(() -> numericInputValidation.validateInputIsNull(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 외에 다른 문자를 입력하면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"10000q", "1!@#$%", "10000원", "1     "})
    void enterNumberWithOtherCharacter(String input) {
        assertThatThrownBy(() -> numericInputValidation.validateInputIsNumeric(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}