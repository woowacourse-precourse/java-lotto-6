import static Display.PURCHASE_AMOUNT_NOT_DIVIDE_ERROR_MESSAGE;
import static Display.PURCHASE_AMOUNT_UNDER_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class PurchaseAmount {

    @DisplayName("구매금액이 1000원 미만일경우 예외처리를 발생한다.")
    @Test
    void validateMinimumPurchaseAmountTest() {

        assertThatThrownBy(() -> new PurchaseAmount(999))
                .isInstanceOf(IllegalArgumentException.class)
    }

    @DisplayName("구매금액이 1000원 단위가 아닐때 예외처리를 발생한다.")
    @Test
    void validateNotDividePurchaseAmountTest() {

        assertThatThrownBy(() -> new PurchaseAmount(1999))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
