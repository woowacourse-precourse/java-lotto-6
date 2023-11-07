package lotto.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static lotto.message.ErrorMessage.ERROR_MESSAGE_HEAD;
import static lotto.message.ErrorMessage.INVALID_MONEY_INPUT_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class InputFormatValidatorTest {
    @DisplayName("1,000원 단위의 양의 정수 값을 입력하면 IllegalArgumentException이 발생하지 않는다.")
    @ParameterizedTest
    @CsvSource({"1000", "3000", "10000", "600000", "7000000"})
    void validateMoneyFormatFromMultipleOfLottoPricePositiveInteger(String input) {
        // given, when, then
        InputFormatValidator.validateMoneyFormat(input);
    }

    @DisplayName("양의 정수가 아닌 값을 입력하면 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @CsvSource({"0", "-1", "가나다라마바사", "abcdef", "12ab가나", "ab12가나"})
    void validateMoneyFormatFromNotPositiveInteger(String input) {
        // given, when, then
        assertThatThrownBy(() -> InputFormatValidator.validateMoneyFormat(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE_HEAD + INVALID_MONEY_INPUT_EXCEPTION);
    }

    @DisplayName("1,000원 단위가 아닌 양의 정수 값을 입력하면 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @CsvSource({"0", "가나다라마바사", "abcdef", "12ab가나", "ab12가나", "-1"})
    void validateMoneyFormatFromNotMultipleOfLottoPricePositiveInteger(String input) {
        // given, when, then
        assertThatThrownBy(() -> InputFormatValidator.validateMoneyFormat(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE_HEAD + INVALID_MONEY_INPUT_EXCEPTION);
    }
}
