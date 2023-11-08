package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasngMoneyTest {
    @DisplayName("구입 금액은 1000단위만 입력가능 하다.")
    @Test
    void createPurchasingMoney() {
        assertThatThrownBy(() -> new PurchasngMoney("10003"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1000 단위로만 입력 가능합니다.");
    }
}
