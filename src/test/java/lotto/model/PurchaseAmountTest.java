package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PurchaseAmountTest {

    @DisplayName("구매 금액이 로또 가격으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createPurchaseAmountByCantDivideMoney() {
        assertThatThrownBy(() -> new PurchaseAmount(1001))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("구매 가능한 로또 개수가 1개보다 작으면 예외가 발생한다.")
    @Test
    void createPurchaseAmountByCantBuyOneLotto() {
        assertThatThrownBy(() -> new PurchaseAmount(0))
                .isInstanceOf(IllegalStateException.class);
    }

}