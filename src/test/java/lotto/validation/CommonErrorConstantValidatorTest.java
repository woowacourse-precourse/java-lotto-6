package lotto.validation;

import static lotto.validation.constant.CommonErrorConstant.EMPTY_MESSAGE;
import static lotto.validation.constant.CommonErrorConstant.NULL_MESSAGE;
import static lotto.validation.constant.CommonErrorConstant.NUMERIC_FORMAT_MESSAGE;
import static lotto.validation.constant.CommonErrorConstant.SPACE_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CommonErrorConstantValidatorTest {

    @Test
    @DisplayName("입력값이 null이면 예외가 발생하는 테스트")
    void testValidateInputNull() {
        CommonErrorValidator inputValidation = new CommonErrorValidator();

        String input = null;

        assertThatThrownBy(() -> inputValidation.validateInputNull(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NULL_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    @DisplayName("입력값이 빈 값이면 예외가 발생하는 테스트")
    void testValidateInputEmpty(String input) {
        CommonErrorValidator inputValidation = new CommonErrorValidator();

        assertThatThrownBy(() -> inputValidation.validateInputEmpty(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EMPTY_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "   "})
    @DisplayName("입력값이 공백으로만 이루어져 있으면 예외가 발생하는 테스트")
    void testValidateInputSpace(String input) {
        CommonErrorValidator inputValidation = new CommonErrorValidator();

        assertThatThrownBy(() -> inputValidation.validateInputSpace(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(SPACE_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "7", "14000"})
    @DisplayName("입력에 대해 null,빈값,공백 검증을 하여 정상 입력이면 예외가 발생하지 않아야 하는 테스트")
    void testValidateNullEmptySpace(String input) {
        CommonErrorValidator inputValidation = new CommonErrorValidator();

        assertThatCode(() -> inputValidation.validateNullEmptySpace(input))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"포비", "b ", "10e"})
    @DisplayName("입력값이 숫자가 아니면 예외가 발생하는 테스트")
    void testValidateInputNumericFormat(String input) {
        CommonErrorValidator inputValidation = new CommonErrorValidator();

        assertThatThrownBy(() -> inputValidation.validateInputNumericFormat(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMERIC_FORMAT_MESSAGE.getMessage());
    }
}