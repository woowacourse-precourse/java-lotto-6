package lotto.validator;

import static lotto.validator.Error.NOT_NUMERIC_INPUT;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.validator.Validator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @DisplayName("숫자 입력 검증")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1024"})
    void validateNumeric(String input) {
        assertDoesNotThrow(() -> Validator.validateNumeric(input));
    }

    @DisplayName("숫자 입력 검증_0이상의 숫자만 허용")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "ddf", "1dfae"})
    void validateNumericFail(String input) {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateNumeric(input));
    }

    @DisplayName("예외 발생시 적절한 메세지 출력")
    @Test
    void validateErrorMessage() {
        Assertions.assertThatThrownBy(() -> Validator.validateNumeric("-12e"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_NUMERIC_INPUT.message())
                .hasMessageStartingWith("[ERROR]");
    }
}