package lotto.model;

import static lotto.constant.ValidateMessage.PURCHASE_PRICE_CAN_NOT_BE_0;
import static lotto.constant.ValidateMessage.PURCHASE_PRICE_IS_NOT_DIVIDED_1000;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasePriceTest {

    @DisplayName("구입 금액은 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void isNotDIVIDEDBy1000Test() {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new PurchasePrice(999));

        //then
        assertTrue(exception.getMessage().contains(PURCHASE_PRICE_IS_NOT_DIVIDED_1000.message));
    }

    @DisplayName("구입 금액은 1,000원 단위이다.")
    @Test
    void isDIVIDEDBy1000Test() {
        //given
        PurchasePrice purchasePrice = new PurchasePrice(8000);

        //then
        assertThat(purchasePrice.getPurchasePrice()).isEqualTo(8000);
        assertThat(purchasePrice.getCount()).isEqualTo(8);
    }

    @DisplayName("구입 금액은 0원이면 안된다.")
    @Test
    void isZeroTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new PurchasePrice(0));

        //then
        assertTrue(exception.getMessage().contains(PURCHASE_PRICE_CAN_NOT_BE_0.message));
    }
}