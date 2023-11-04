package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.dto.PurchaseAmountDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {
    @Nested
    @DisplayName("validatePurchaseAmount 메소드 test")
    class ValidatePurchaseAmountDto {
        @DisplayName("구입 금액이 " + PurchaseAmountDto.PURCHASE_AMOUNT_UNIT + " 단위면 검증 통과")
        @Test
        void Amount_is_divisible_by_the_purchase_amount_unit() {
            // given
            int amount1 = 1_000;
            int amount2 = 15_000;
            int amount3 = 1_000_000;

            // when
            // then
            PurchaseAmountDto purchaseAmount1 = new PurchaseAmountDto(amount1);
            PurchaseAmountDto purchaseAmount2 = new PurchaseAmountDto(amount2);
            PurchaseAmountDto purchaseAmount3 = new PurchaseAmountDto(amount3);
        }

        @DisplayName("구입 금액이 " + PurchaseAmountDto.PURCHASE_AMOUNT_UNIT + " 단위가 아니면 예외 발생")
        @Test
        void test() {
            // given
            int amount1 = 1_001;
            int amount2 = 43_200;

            // when
            // then
            assertThatThrownBy(() -> new PurchaseAmountDto(amount1)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(PurchaseAmountDto.PURCHASE_AMOUNT_NOT_DIVISIBLE_MESSAGE);
            assertThatThrownBy(() -> new PurchaseAmountDto(amount2)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(PurchaseAmountDto.PURCHASE_AMOUNT_NOT_DIVISIBLE_MESSAGE);
        }
    }
}