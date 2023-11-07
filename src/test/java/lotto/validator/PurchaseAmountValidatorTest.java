package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseAmountValidatorTest {

    @DisplayName("입력금액이 정수가 아닐 때 예외처리한다")
    @Test
    void purchaseAmountNotInteger() {
        assertThatThrownBy(() -> {
            PurchaseAmountValidator.validate("-1");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력금액이 1000원 단위가 아닐 때 예외처리한다")
    @Test
    void purchaseAmountNotNaturalNumber() {
        assertThatThrownBy(() -> {
            PurchaseAmountValidator.validate("1001");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
