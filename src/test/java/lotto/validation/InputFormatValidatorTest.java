package lotto.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static lotto.message.ErrorMessage.ERROR_MESSAGE_HEAD;
import static lotto.message.ErrorMessage.INVALID_MONEY_FORMAT_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class InputFormatValidatorTest {
    @DisplayName("양의 정수 값을 입력하면 IllegalArgumentException이 발생하지 않는다.")
    @ParameterizedTest
    @CsvSource({"1", "9", "10", "100", "1000", "10000"})
    void validateMoneyFormatFromPositiveInteger(String input) {
        // given, when, then
        InputFormatValidator.validateMoneyFormat(input);
    }

    @DisplayName("양의 정수가 아닌 값을 입력하면 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @CsvSource({"0", "가나다라마바사", "abcdef", "12ab가나", "ab12가나", "-1"})
    void validateMoneyFormatFromNotPositiveInteger(String input) {
        // given, when, then
        assertThatThrownBy(() -> InputFormatValidator.validateMoneyFormat(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE_HEAD + INVALID_MONEY_FORMAT_EXCEPTION);
    }
}
