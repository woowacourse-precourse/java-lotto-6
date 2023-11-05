package lotto.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    @DisplayName("PurchaseAmount는 필드 값을 포장해야 한다.")
    @Test
    public void quantity_value_test() {
        // given
        Integer amount = 1000;

        // when
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);
        Integer result = purchaseAmount.amount();

        // then
        assertEquals(result, amount);
    }

    @DisplayName("두 PurchaseAmount의 필드 값이 동일하면 두 레코드는 동일해야 한다.")
    @Test
    public void quantity_equality_test() {
        // when
        PurchaseAmount purchaseAmount1 = new PurchaseAmount(1000);
        PurchaseAmount purchaseAmount2 = new PurchaseAmount(1000);
        PurchaseAmount purchaseAmount3 = new PurchaseAmount(2000);

        // then
        assertEquals(purchaseAmount1.hashCode(), purchaseAmount2.hashCode());
        assertEquals(purchaseAmount1, purchaseAmount2);
        assertNotEquals(purchaseAmount1, purchaseAmount3);
    }
}
