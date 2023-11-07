package lotto.view;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseAmountInputTest {

    @Test
    @DisplayName("1000원 단위가 아닌 경우 에러 발생")
    void validateWithValidInput() {
        PurchaseAmountInput input = new PurchaseAmountInput();
        String validInput = "1000";
        assertThatCode(() -> input.validate(validInput)).doesNotThrowAnyException();
    }

}
