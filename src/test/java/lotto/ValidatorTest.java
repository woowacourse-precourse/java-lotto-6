package lotto;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
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
}