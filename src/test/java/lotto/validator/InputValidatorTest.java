package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    private InputValidator inputValidator = new InputValidator();

    @ParameterizedTest
    @ValueSource(strings = {"1", "11", "111", "1111"})
    void 숫자_입력_검증_성공_테스트(String number) {
        inputValidator.validateNumber(number);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.1", "abc", "1qw."})
    void 숫자_입력_검증_실패_테스트(String number) {
        assertThatThrownBy(() -> {
            inputValidator.validateNumber(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}