package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {
    @ParameterizedTest
    @DisplayName("빈값 입력 예외 테스트")
    @ValueSource(strings = {"", " ", "  ", "   "})
    void invalidInputsTest1(String input) {
        Assertions.assertThatThrownBy(() -> Validator.isEmpty(input)).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INPUT_VALUE);
    }

    @ParameterizedTest
    @DisplayName("숫자가 아닌 입력 예외 테스트")
    @ValueSource(strings = {"1a", "abd21", "45.2", "뮹2", ",g"})
    void invalidInputsTest2(String input) {
        Assertions.assertThatThrownBy(() -> Validator.isNumeric(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INPUT_NUMERIC);
    }

    @ParameterizedTest
    @DisplayName("1,000원 단위가 아닌 입력 예외 테스트")
    @ValueSource(strings = {"1001", "999", "100", "1100", "100001"})
    void invalidInputsTest3(String input) {
        Assertions.assertThatThrownBy(() -> Validator.isThousandUnit(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INPUT_THOUSAND_UNIT);
    }
}