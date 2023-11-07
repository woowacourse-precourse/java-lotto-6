package lotto.model;

import lotto.exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseAmountTest {

    @DisplayName("구입 금액이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void createPurchaseAmountByString() {
        assertThatThrownBy(() -> new PurchaseAmount("Test"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.IS_NOT_DIGIT);
    }

    @DisplayName("구입 금액이 비어있을 경우 예외가 발생한다.")
    @Test
    void createPurchaseAmountByEmpty() {
        assertThatThrownBy(() -> new PurchaseAmount(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_EMPTY_OR_BLANK);
    }

    @DisplayName("구입 금액이 0일 경우 예외가 발생한다.")
    @Test
    void createPurchaseAmountByZero() {
        assertThatThrownBy(() -> new PurchaseAmount("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_MINUS_OR_ZERO);
    }

    @DisplayName("구입 금액이 음수일 경우 예외가 발생한다.")
    @Test
    void createPurchaseAmountByMinus() {
        assertThatThrownBy(() -> new PurchaseAmount("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_MINUS_OR_ZERO);
    }

    @DisplayName("구입 금액이 1000원으로 나누어 떨어지지 않을 경우 예외가 발생한다.")
    @Test
    void createPurchaseAmountByNonDivisible() {
        assertThatThrownBy(() -> new PurchaseAmount("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.IS_NOT_BEING_DIVIDED);
    }

}
