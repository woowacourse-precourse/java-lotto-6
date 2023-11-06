package lotto.model;

import lotto.constant.Constants;
import lotto.message.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseAmountTest {

    @DisplayName("올바른 값을 입력하면 성공")
    @Test
    void inputRight() {
        String inputValue = "4000";
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputValue);
        assertThat(purchaseAmount.getPurchaseAmount()).isEqualTo(4000);
    }

    @DisplayName("빈 칸을 입력하면 예외 발생")
    @Test
    void inputNoting() {
        String inputValue = "";
        assertThatThrownBy(() -> new PurchaseAmount(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_EMPTY_STRING_MESSAGE.getMessage());
    }

    @DisplayName("숫자를 입력하지 않으면 예외 발생")
    @Test
    void inputNotNumber() {
        String inputValue = "1h";
        assertThatThrownBy(() -> new PurchaseAmount(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_ZERO_OR_LESS_MESSAGE.getMessage());
    }

    @DisplayName("0보다 작은 숫자를 입력하면 예외 발생")
    @Test
    void inputUnderZero() {
        String inputValue = "-1000";
        assertThatThrownBy(() -> new PurchaseAmount(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_ZERO_OR_LESS_MESSAGE.getMessage());
    }

    @DisplayName("1000으로 나누어 떨어지지 않는 수를 입력하면 예외 발생")
    @Test
    void inputNotMultipleOfUnits() {
        String inputValue = "1001";
        Object [] values = {Constants.PURCHASE_AMOUNT_UNIT.getValue()};
        assertThatThrownBy(() -> new PurchaseAmount(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_NOT_MULTIPLE_OF_UNIT_MESSAGE.getMessage(values));
    }
}
