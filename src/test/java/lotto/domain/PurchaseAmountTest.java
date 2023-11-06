package lotto.domain;

import lotto.constants.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    private static final int MIN_PURCHASE_AMOUNT = 1_000;
    private static final int MAX_PURCHASE_AMOUNT = 100_000;

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createPurchaseAmount_Fail_ByInvalidUnit() {
        // when, then
        Assertions.assertThatThrownBy(() -> new PurchaseAmount(1200))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT.getMessage());
    }

    @DisplayName("구입 금액이 최솟값보다 작으면 예외가 발생한다.")
    @Test
    void createPurchaseAmount_Fail_ByLessThanMinimum() {
        // when, then
        Assertions.assertThatThrownBy(() -> new PurchaseAmount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_PURCHASE_AMOUNT_RANGE.getMessage()
                        .formatted(MIN_PURCHASE_AMOUNT, MAX_PURCHASE_AMOUNT));
    }

    @DisplayName("구입 금액이 최댓값보다 크면 예외가 발생한다.")
    @Test
    void createPurchaseAmount_Fail_ByLessThanMaximum() {
        // when, then
        Assertions.assertThatThrownBy(() -> new PurchaseAmount(1000000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_PURCHASE_AMOUNT_RANGE.getMessage()
                        .formatted(MIN_PURCHASE_AMOUNT, MAX_PURCHASE_AMOUNT));
    }

    @DisplayName("decrease를 호출하면 구입 금액이 로또 가격만큼 감소한다.")
    @Test
    void decrease_Success() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(2000);

        // when
        int decreasedAmount = purchaseAmount.decrease(1000);

        // then
        Assertions.assertThat(decreasedAmount).isEqualTo(1000);
    }
}
