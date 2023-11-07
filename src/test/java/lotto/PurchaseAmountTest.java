package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PurchaseAmountTest {
    PurchaseAmount purchaseAmount = new PurchaseAmount();
    @DisplayName("입력값이 1000원 단위의 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void 구입금액_검증() {
        // given
        String amount1 = "";        // 입력이 없는 경우
        String amount2 = " ";       // 공백인 경우
        String amount3 = "abc";     // 문자인 경우
        String amount4 = "10500";    // 1000원 단위가 아닌 경우
        String amount5 = "-2000";      // 음수인 경우

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            purchaseAmount.validate(amount1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            purchaseAmount.validate(amount2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            purchaseAmount.validate(amount3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            purchaseAmount.validate(amount4);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            purchaseAmount.validate(amount5);
        });
    }

    @DisplayName("구입금액이 정상적으로 할당되는지 확인한다.")
    @Test
    void 구입금액_정삭작동() {
        // given
        String amount = "6000";

        // when
        purchaseAmount.validate(amount);

        // then
        assertEquals(6000, purchaseAmount.getAmount());
    }
}