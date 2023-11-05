package lotto.domain.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PurchaseAmountDtoTest {
    @Nested
    @DisplayName("purchaseQuantityLottos 메소드 test")
    class PurchaseQuantityLottos {
        @DisplayName("구입 금액을 " + PurchaseAmountDto.PURCHASE_AMOUNT_UNIT + "으로 나눈값을 반환한다.")
        @Test
        void test() {
            // given
            PurchaseAmountDto purchaseAmountDto = new PurchaseAmountDto(15_000);

            // when
            int lottosCount = purchaseAmountDto.purchaseQuantityLottos();

            // then
            assertThat(lottosCount).isEqualTo(15_000 / PurchaseAmountDto.PURCHASE_AMOUNT_UNIT);
        }
    }
}