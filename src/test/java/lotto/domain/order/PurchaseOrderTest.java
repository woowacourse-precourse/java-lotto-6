package lotto.domain.order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseOrderTest {

    @Test
    @DisplayName("구매 수량이 1000원 단위이면 정상적으로 생성한다.")
    void 구매_수량이_1000원_단위이면_정상적으로_생성한다() {
        // given
        var purchaseAmount = 1_000;

        // when
        var purchaseOrder = new PurchaseOrder(purchaseAmount);

        // then
        assertThat(purchaseOrder).isNotNull();
        assertThat(purchaseOrder.amount()).isEqualTo(purchaseAmount);
    }

    @Test
    @DisplayName("구매 수량이 0이하이면 예외를 발생시킨다.")
    void 구매_수량이_0이하이면_예외를_발생시킨다() {
        // given
        var purchaseAmount = 0;

        // when & then
        assertThatThrownBy(() -> new PurchaseOrder(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매 수량이 1000원 단위가 아니면 예외를 발생시킨다.")
    void 구매_수량이_1000원_단위가_아니면_예외를_발생시킨다() {
        // given
        var purchaseAmount = 1_100;

        // when & then
        assertThatThrownBy(() -> new PurchaseOrder(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매 수량을 반환한다.")
    void 구매_수량을_반환한다() {
        // given
        var purchaseAmount = 1_000;
        var purchaseOrder = new PurchaseOrder(purchaseAmount);

        // when
        var quantity = purchaseOrder.getQuantity();

        // then
        assertThat(quantity).isEqualTo(1);
    }
}
