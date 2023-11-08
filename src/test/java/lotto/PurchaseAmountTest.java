package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PurchaseAmountTest {
    PurchaseAmount purchaseAmount = new PurchaseAmount();

    @DisplayName("입력값이 정수가 아닌 경우 예외가 발생한다.")
    @Test
    void 구입금액_정수형_검증() {
        // given
        String amount1 = "";
        String amount2 = " ";
        String amount3 = "1000.0";
        String amount4 = "abc";
        String amount5 = null;

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            purchaseAmount.convertToInt(amount1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            purchaseAmount.convertToInt(amount2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            purchaseAmount.convertToInt(amount3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            purchaseAmount.convertToInt(amount4);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            purchaseAmount.convertToInt(amount5);
        });
    }

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
}