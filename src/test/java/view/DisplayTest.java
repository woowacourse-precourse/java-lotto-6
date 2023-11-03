package view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static view.Display.PURCHASE_AMOUNT_NOT_DIVIDE_ERROR_MESSAGE;
import static view.Display.PURCHASE_AMOUNT_UNDER_ERROR_MESSAGE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class DisplayTest {

    @DisplayName("구매금액이 1000원 미만일경우 예외처리를 발생한다.")
    @Test
    void validateMinimumPurchaseAmountTest() {

        assertThatThrownBy(() -> new Display(999))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PURCHASE_AMOUNT_UNDER_ERROR_MESSAGE);
    }

    @DisplayName("구매금액이 1000원 단위가 아닐때 예외처리를 발생한다.")
    @Test
    void validateNotDividePurchaseAmountTest() {

        assertThatThrownBy(() -> new Display(1999))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PURCHASE_AMOUNT_NOT_DIVIDE_ERROR_MESSAGE);
    }

}
