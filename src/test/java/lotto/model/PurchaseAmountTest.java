package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    @Test
    @DisplayName("구입 수량 테스트")
    void purchaseAmountTest() {
        // given
        PurchaseAmount amount = new PurchaseAmount(8000);

        // when
        int numberOfTickets = amount.getNumberOfTickets();

        // then
        assertThat(numberOfTickets).isEqualTo(8);
    }
}