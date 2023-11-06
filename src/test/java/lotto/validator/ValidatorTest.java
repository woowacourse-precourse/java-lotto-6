package lotto.validator;

import static lotto.validator.Error.NOT_NUMERIC_INPUT;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @DisplayName("당첨 번호 입력 검증")
    @ParameterizedTest
    @ValueSource(strings = {"1", "1,2,3,4,5,6"})
    void validateWinningNumbersInput(String input) {
        assertDoesNotThrow(() -> Validator.validateWinningNumbersInput(input));
    }

    @DisplayName("당첨 번호 입력 검증_숫자가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1,A,3,4,5,6"})
    void validateWinningNumbersInputFail(String input) {
        Assertions.assertThatThrownBy(() -> Validator.validateWinningNumbersInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.INVALID_FORMAT_WINNING_NUMBERS.message());
    }

    @DisplayName("구매 금액 검증")
    @Test
    void validatePayment() {
        assertDoesNotThrow(() -> Validator.validatePayment(3000));
    }

    @DisplayName("구매 금액 검증_0원인 경우")
    @Test
    void validatePayment_notPositive_fail() {
        Assertions.assertThatThrownBy(() -> Validator.validatePayment(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.INVALID_PAYMENT.message());
    }

    @DisplayName("구매 금액 검증_1000원으로 나누어 떨어지지 않는 경우")
    @Test
    void validatePayment_wrongUnit_fail() {
        Assertions.assertThatThrownBy(() -> Validator.validatePayment(1320))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.INVALID_PAYMENT.message());
    }
}