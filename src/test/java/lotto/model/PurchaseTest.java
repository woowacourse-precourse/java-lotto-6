package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PurchaseTest {

    @DisplayName("입력된 구매금액을 토대로 Purchase 객체가 생성된다.")
    @Test
    void fromPurchaseAmount() {
        // given
        String input = "11000";

        // when
        Purchase purchase = Purchase.fromPurchaseAmount(input);

        // then
        assertThat(purchase.getPurchaseCount()).isEqualTo(11);
    }

}