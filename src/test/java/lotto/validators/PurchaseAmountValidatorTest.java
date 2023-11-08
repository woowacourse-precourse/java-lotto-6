package lotto.validators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountValidatorTest {

    @DisplayName("구입금액에 숫자가 아닌 문자가 있다면 예외가 발생한다.")
    @Test
    void validateType() {
        assertThatThrownBy(() -> PurchaseAmountValidator.validateType("100a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 1,000원 단위가 아니라면 예외가 발생한다.")
    @Test
    void validateUnit() {
        assertThatThrownBy(() -> PurchaseAmountValidator.validateUnit("1010"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}