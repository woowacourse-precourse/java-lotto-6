package lotto.controller.dto.input;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.controller.exception.InvalidLottoPriceUnitException;
import lotto.controller.exception.NumericInputValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

final class BuyLottosInputTest {
    @DisplayName("1,000 단위로 나누어 떨어지는 문자열을 입력하여 BuyLottosDto 생성 가능")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "10000"})
    void from_withNumericStringDivisibleByLottoPrice_shouldCreateInstance(final String input) {
        // given
        // when
        final BuyLottosInput dto = BuyLottosInput.from(input);

        // then
        assertThat(dto.getAmount()).isEqualTo(Long.parseLong(input));
    }

    @DisplayName("1,000 단위로 나누어 떨어지지 않는 문자열을 입력하여 BuyLottosDto 생성 시, 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1001", "10203", "50"})
    void from_withNumericStringNotDivisibleByLottoPrice_shouldThrowException(final String input) {
        // given
        // when
        // then
        assertThatThrownBy(() ->
                BuyLottosInput.from(input))
                .isInstanceOf(InvalidLottoPriceUnitException.class)
                .hasMessage(InvalidLottoPriceUnitException.INVALID_LOTTO_PRICE_UNIT_EXCEPTION_MESSAGE);
    }

    @DisplayName("숫자 외의 문자가 포함된 문자열을 입력하여 BuyLottosDto 생성 시, 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"x", "o", "1000j"})
    void from_includesNotNumericString_shouldThrowException(final String input) {
        // given
        // when
        // then
        assertThatThrownBy(() ->
                BuyLottosInput.from(input))
                .isInstanceOf(NumericInputValidationException.class)
                .hasMessage(NumericInputValidationException.NUMERIC_INPUT_VALIDATION_EXCEPTION);
    }

    /**
     * 입력 단에서 Null 및 Blank 검증을 완료하기 때문에 테스트 배제
     */
//    @DisplayName("null이나 빈 문자열을 입력하여 BuyLottosDto 생성 시, 예외 발생")
//    @ParameterizedTest
//    @NullAndEmptySource
//    void from_withBlank_shouldThrowException(final String input) {
//        // given
//        // when
//        // then
//        assertThatThrownBy(() ->
//                BuyLottosDto.from(input))
//                .isInstanceOf(BlankInputException.class)
//                .hasMessage(BlankInputException.BLANK_INPUT_EXCEPTION_MESSAGE);
//    }
}