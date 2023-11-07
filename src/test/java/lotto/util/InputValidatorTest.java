package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @DisplayName("입력받은 문자열이 숫자가 아니면 예외가 발생한다.")
    @Test
    void validateNumberType() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateNumberType("11a"));
    }

    @DisplayName("입력받은 금액이 0보다 작으면 예외가 발생한다.")
    @Test
    void validatePurchaseAmount() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validatePurchaseAmount(-1));
    }

    @DisplayName("입력받은 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void validatePurchaseAmountByUnit() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validatePurchaseAmount(1001));
    }

}
