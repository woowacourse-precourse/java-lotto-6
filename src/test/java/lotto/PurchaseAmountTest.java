package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PurchaseAmountTest {
    PurchaseAmount purchaseAmount = new PurchaseAmount();

    @DisplayName("입력값이 1000원 단위가 아닌 경우 예외가 발생한다.")
    @Test
    void 구입금액_단위_검증() {
        // given
        int amount = 12300;

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            purchaseAmount.checkUnit1000(amount);
        });
    }

    @DisplayName("정상적으로 구입금액이 입력되는지 확인한다.")
    @Test
    void 구입금액_입력_정상_작동_확인() {
        // given
        String input_amount = "123000";

        // when
        purchaseAmount.inputAmount(input_amount);

        // then
        assertEquals(123000, purchaseAmount.getAmount());
    }
}