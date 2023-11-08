package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatThrownBy;


class PurchaseAmountTest {
    @DisplayName("구매금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createtPurchaseAmounDividedThousand() {
        assertThatThrownBy(() -> new PurchaseAmount(11111))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매금액이 0원이면 예외가 발생한다.")
    @Test
    void createPurchaseAmounByZero() {
        assertThatThrownBy(() -> new PurchaseAmount(0))
                .isInstanceOf(IllegalArgumentException.class);
    }



}