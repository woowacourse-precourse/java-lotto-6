package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseProcessorTest {


    @DisplayName("올바른 가격으로 로또 수량 계산")
    @Test
    void validPrice() {
        PurchaseProcessor purchaseProcessor = new PurchaseProcessor("3000");
        assertThat(purchaseProcessor.getLottoCount()).isEqualTo(3);
    }

}

