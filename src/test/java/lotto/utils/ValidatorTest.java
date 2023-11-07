package lotto.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import lotto.exception.defaultexception.DefaultErrorMessage;
import lotto.exception.defaultexception.LottoDefaultException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @DisplayName("정상적인 문자열 입력")
    @Test
    void inputString() {
        //given
        String[] inputs = {"1", "3", "4", "5", "40", "42"};

        // when & then
        assertDoesNotThrow(() -> Validator.validateInputValue(inputs));
    }

    @DisplayName("공백이 포함된 문자열 배열 입력")
    @ParameterizedTest(name = "공백이 포함된 문자열 배열: {0}")
    @ValueSource(strings = {"1 2", "3 4 5", "6 7 8 9"})
    void inputStringWithWhiteSpace(String input) {
        // when & then
        assertThatThrownBy(() -> Validator.validateInputValue(input))
                .isInstanceOf(LottoDefaultException.class)
                .hasMessageContaining(DefaultErrorMessage.WHITE_SPACE.getMessage());
    }

    @DisplayName("빈 문자열 입력")
    @Test
    void inputStringWithBlank() {
        //given
        String[] inputs = {"1", "3", "4", "", "40", "42"};

        // when & then
        assertThatThrownBy(() -> Validator.validateInputValue(inputs))
                .isInstanceOf(LottoDefaultException.class)
                .hasMessageContaining(DefaultErrorMessage.BLANK_INPUT.getMessage());
    }

    @DisplayName("숫자가 아닌 문자열 입력")
    @Test
    void inputStringWithNonNumeric() {
        //given
        String[] inputs = {"1", "3", "4", "5", "40", "42a"};

        // when & then
        assertThatThrownBy(() -> Validator.validateInputValue(inputs))
                .isInstanceOf(LottoDefaultException.class)
                .hasMessageContaining(DefaultErrorMessage.NON_NUMERIC.getMessage());
    }
}