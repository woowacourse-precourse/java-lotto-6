package lotto.validator;

import lotto.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputPurchaseAmountValidatorTest {

    private final InputPurchaseAmountValidator validator = new InputPurchaseAmountValidator();

    @DisplayName("구입 금액이 공백일 경우 예외 체크")
    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "   "})
    void validatePurchaseAmountIsBlank(String input) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> validator.validate(input));
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.INPUT_DOES_NOT_BLANK.getMessage());
    }

    @DisplayName("구입 금액이 정수가 아닐 경우 예외 체크")
    @ParameterizedTest
    @ValueSource(strings = {"ㅁㄱㅂ1", "asd1", "3ss"})
    void validatePurchaseAmountIsNumeric(String input) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> validator.validate(input));
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.INPUT_MUST_BE_NUMERIC.getMessage());
    }

    @DisplayName("구입 금액이 양수가 아닐 경우 예외 체크")
    @ParameterizedTest
    @ValueSource(strings = {"-1000", "-2000", "-30000"})
    void validatePurchaseAmountIsPositive(String input) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> validator.validate(input));
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.INPUT_MUST_BE_POSITIVE.getMessage());
    }

    @DisplayName("구입 금액이 1000원 단위가 아닐 경우 예외 체크")
    @ParameterizedTest
    @ValueSource(strings = {"1005", "2100", "55001"})
    void validatePurchaseAmountIsMultipleOfLottoPriceUnit(String input) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> validator.validate(input));
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.INPUT_MUST_BE_MULTIPLE_OF_LOTTO_PRICE_UNIT.getMessage());
    }

    @DisplayName("구입 금액이 올바르게 처리되는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "50000"})
    void validatePurchaseAmount_DoesNotThrowException(String input) {
        assertDoesNotThrow(() -> validator.validate(input));
    }
}