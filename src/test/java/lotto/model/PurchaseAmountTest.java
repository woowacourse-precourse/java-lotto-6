package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {
    @Test
    @DisplayName("PurchaseAmount가 잘 초기화 되는지 확인")
    void initPurchaseAmount() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("50000");

        assertThat(purchaseAmount.getPurchaseAmount()).isEqualTo(50000);
    }

}
