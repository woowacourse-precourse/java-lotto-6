package lotto.Validator;

import static lotto.config.ErrorMessage.INPUT_AMOUNT_CHARACTER_ERROR_MESSAGE;
import static lotto.config.ErrorMessage.INPUT_AMOUNT_DIVISION_ERROR_MESSAGE;
import static lotto.config.ErrorMessage.INPUT_AMOUNT_TOO_LARGE_ERROR_MESSAGE;
import static lotto.config.ErrorMessage.TOO_LONG_INPUT_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("PurchaseAmountValidator 클래스 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PurchaseAmountValidatorTest {
    private final PurchaseAmountValidator validator = new PurchaseAmountValidator();

    @ParameterizedTest
    @ValueSource(strings = {"3000", "10000", "5000000", "31000", "1500000"})
    void 정상적인_구입_금액_입력값을_확인한다(String input) {
        assertDoesNotThrow(() -> validator.valid(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1a928", "1 23", "1:23", "1,000", ",1230"})
    void 숫자가_포함되지_않은_입력값에_예외를_발생한다(String input) {
        assertThatThrownBy(() -> validator.valid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_AMOUNT_CHARACTER_ERROR_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1200", "1300", "1234", "00012"})
    void 숫자_1000으로_나누어지지_않는_입력값에_예외를_발생한다(String input) {
        assertThatThrownBy(() -> validator.valid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_AMOUNT_DIVISION_ERROR_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"10000000", "11000000", "123000000", "12340000"})
    void 로또_10000장_이상을_구매하는_입력값에_예외를_발생한다(String input) {
        assertThatThrownBy(() -> validator.valid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_AMOUNT_TOO_LARGE_ERROR_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234567890", "1234567000", "abcdefghij"})
    void 너무_긴_입력값에_예외를_발생한다(String input) {
        assertThatThrownBy(() -> validator.valid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TOO_LONG_INPUT_ERROR_MESSAGE.getMessage());
    }
}
