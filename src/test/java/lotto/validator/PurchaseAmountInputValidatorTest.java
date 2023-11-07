package lotto.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseAmountInputValidatorTest {

    @Test
    @DisplayName("유효한 구입 금액이 입력되면 예외가 발생하지 않아야 함")
    void validateWithValidInput() {
        PurchaseAmountInputValidator validator = new PurchaseAmountInputValidator();
        String validInput = "1000";
        assertThatCode(() -> validator.validate(validInput)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아닌 경우 예외가 발생해야 함")
    void validateWithInvalidAmount() {
        PurchaseAmountInputValidator validator = new PurchaseAmountInputValidator();
        String invalidInput = "1500";
        assertThatThrownBy(() -> validator.validate(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 1,000원 단위로 입력 가능합니다.");
    }

    @Test
    @DisplayName("구입 금액에 유효하지 않은 숫자가 입력되면 예외가 발생해야 함")
    void validateWithInvalidNumber() {
        PurchaseAmountInputValidator validator = new PurchaseAmountInputValidator();
        String invalidInput = "abc";
        assertThatThrownBy(() -> validator.validate(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효한 숫자로 입력하시길 바랍니다.");
    }

}
