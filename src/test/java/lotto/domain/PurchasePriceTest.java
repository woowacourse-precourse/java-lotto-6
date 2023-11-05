package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PurchasePriceTest {
    private int price;
    private final PurchasePrice purchasePrice;

    private PurchasePriceTest() {
        price = 14000;
        this.purchasePrice = new PurchasePrice(price);
    }

    @DisplayName("구입 금액에 맞게 로또 개수 생성됐는지 확인")
    @Test
    void getLottoAmount() {
        assertThat(purchasePrice.getLottoAmount()).isEqualTo(14);
    }
}
