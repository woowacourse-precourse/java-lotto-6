package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    private static final int LOTTO_PRICE = 1000;

    @DisplayName("decrease를 호출하면 구입 금액이 로또 가격만큼 감소한다.")
    @Test
    void decrease_Success() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(2000);

        // when
        int decreasedAmount = purchaseAmount.decrease(LOTTO_PRICE);

        // then
        Assertions.assertThat(decreasedAmount).isEqualTo(1000);
    }
}