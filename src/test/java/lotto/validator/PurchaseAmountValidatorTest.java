package lotto.validator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = { "5000", "10000", "20000" })
    @DisplayName("유효한 구입 금액을 입력하는 경우")
    void validateValidPurchaseAmount(String input) {
        int validAmount = PurchaseAmountValidator.parseAndValidatePurchaseAmount(input);
        assertEquals(Integer.parseInt(input), validAmount);
    }

    @ParameterizedTest
    @ValueSource(strings = { "500", "0" })
    @DisplayName("1000원 미만인 경우 - 예외 발생")
    void validateLessThanMinimumPurchaseAmount(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> PurchaseAmountValidator.parseAndValidatePurchaseAmount(input));
        assertEquals("[ERROR] 최소 구입 금액은 1,000원입니다.", exception.getMessage());
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("빈값을 입력한 경우 - 예외 발생")
    void validateEmptyPurchaseAmount(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> PurchaseAmountValidator.parseAndValidatePurchaseAmount(input));
        assertEquals("[ERROR] 올바른 금액을 입력해 주세요.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = { "1500", "2500", "3500" })
    @DisplayName("1000원 단위가 아닌 경우 - 예외 발생")
    void validateNonMultipleOf1000PurchaseAmount(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> PurchaseAmountValidator.parseAndValidatePurchaseAmount(input));
        assertEquals("[ERROR] 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어져야 합니다.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = { "abc", "1.5", "1000원" })
    @DisplayName("숫자가 아닌 입력인 경우 - 예외 발생")
    void validateNonNumericInput(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> PurchaseAmountValidator.parseAndValidatePurchaseAmount(input));
        assertEquals("[ERROR] 올바른 금액을 입력해 주세요.", exception.getMessage());
    }
}
