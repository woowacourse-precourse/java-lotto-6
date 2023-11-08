package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.constant.ExceptionConstant;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    InputValidator inputValidator = new InputValidator();

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "    "})
    void 입력값이_빈칸일_경우_예외발생(String userInput) {
        assertThatThrownBy(() -> inputValidator.validateUserInput(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionConstant.INPUT_IS_ESSENTIAL.getMessage());
    }

    @ParameterizedTest
    @NullSource
    void 입력값이_null일_경우_예외발생(String userInput) {
        assertThatThrownBy(() -> inputValidator.validateUserInput(userInput))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining(ExceptionConstant.INPUT_IS_ESSENTIAL.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"일", "2삼"})
    void 입력값이_숫자가_아닐경우_예외발생(String userInput) {
        assertThatThrownBy(() -> inputValidator.validateUserInput(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionConstant.INPUT_IS_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "99"})
    void 입력값이_정수일_경우_예외발생_하지않음(String userInput) {
        assertThatCode(() -> inputValidator.validateUserInput(userInput))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-99"})
    void 입력값이_정수가_아닐경우_예외발생(String userInput) {
        assertThatThrownBy(() -> inputValidator.validateUserInput(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionConstant.INPUT_IS_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5"})
    void 입력값이_정수면_정상작동(String userInput) {
        assertThatCode(() -> inputValidator.validateUserInput(userInput.replaceAll(",", "")))
                .doesNotThrowAnyException();
    }
}