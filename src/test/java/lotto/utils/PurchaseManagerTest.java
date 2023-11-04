package lotto.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class PurchaseManagerTest {

    @DisplayName("구입 금액을 로또 가격에 따라 나눈다.")
    @Test
    void dividePurchaseAmount() {
        // given
        int purchaseAmount = 8000;

        // when
        int dividePurchaseAmount = PurchaseManager.dividePurchaseAmount(purchaseAmount);

        // then
        Assertions.assertThat(dividePurchaseAmount).isEqualTo(8);
    }
}