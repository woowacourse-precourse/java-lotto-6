package lotto.validator;

import static lotto.constants.Error.COMMA_ERROR;
import static lotto.constants.Error.NOT_NUMBER_ERROR;
import static lotto.constants.Error.NOT_POSITIVE_NUMBER_ERROR;
import static lotto.constants.Error.RANGE_ERROR;
import static lotto.constants.Error.REMAINDER_ERROR;
import static lotto.constants.Error.ZERO_INCLUSION_ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @DisplayName("입력이 정수가 아닐 때, 예외 처리 + 메시지 출력")
    @ParameterizedTest
    @ValueSource(strings = {"a", " ", "1.1"})
    void checkNumber(String userInput) {
        assertThatThrownBy(() -> Validator.checkNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_NUMBER_ERROR.getMessage());
    }

    @DisplayName("입력이 1000단위가 아닐 때, 예외 처리 + 메시지 출력")
    @ParameterizedTest
    @ValueSource(ints = {1001, 999})
    void checkThousands(Integer userInput) {
        assertThatThrownBy(() -> Validator.checkThousands(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(REMAINDER_ERROR.getMessage());
    }

    @DisplayName("입력 앞에 0이 있을 때, 예외 처리 + 메시지 출력")
    @ParameterizedTest
    @ValueSource(strings = {"0a", "01", "0"})
    void checkZero(String userInput) {
        assertThatThrownBy(() -> Validator.checkZero(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ZERO_INCLUSION_ERROR.getMessage());
    }

    @DisplayName("입력이 양수가 아닐 때, 예외 처리 + 메시지 출력")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void checkPositiveNumber(Integer number) {
        assertThatThrownBy(() -> Validator.checkPositiveNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_POSITIVE_NUMBER_ERROR.getMessage());
    }

    @DisplayName("입력이 로또 번호 범위가 아닐 때, 예외 처리 + 메시지 출력")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46, 100})
    void checkRange(Integer userInput) {
        assertThatThrownBy(() -> Validator.checkRange(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RANGE_ERROR.getMessage());
    }

    @DisplayName("입력 마지막에 콤마가 있을 때, 예외 처리 + 메시지 출력")
    @ParameterizedTest
    @ValueSource(strings = {"123,", "1,23,"})
    void checkComma(String userInput) {
        assertThatThrownBy(() -> Validator.checkComma(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(COMMA_ERROR.getMessage());
    }
}