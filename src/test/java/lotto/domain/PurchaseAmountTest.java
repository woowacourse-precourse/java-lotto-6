package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {
    @Nested
    @DisplayName("purchaseQuantityLottos 메소드 test")
    class PurchaseQuantityLottosTest {
        @DisplayName("구입 금액을 " + PurchaseAmount.PURCHASE_AMOUNT_UNIT + "으로 나눈값을 반환한다.")
        @Test
        void test() {
            // given
            PurchaseAmount purchaseAmount = new PurchaseAmount(15_000);

            // when
            int lottosCount = purchaseAmount.purchaseQuantityLottos();

            // then
            assertThat(lottosCount).isEqualTo(15_000 / PurchaseAmount.PURCHASE_AMOUNT_UNIT);
        }
    }

}