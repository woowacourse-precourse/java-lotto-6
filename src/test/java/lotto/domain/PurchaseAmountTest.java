package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseAmountTest {
    @Test
    @DisplayName("로또 구입 금액 정상 입력")
    void receiveNormalAmountTest() {
        String amount = "2000";
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);
        assertThat(purchaseAmount.getAmount()).isEqualTo(2000);
    }
}
