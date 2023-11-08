package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @DisplayName("구매한 로또 티켓 수량이 정상적으로 출력되는지 확인한다.")
    @Test
    void validatePurchaseQuantity() {
        LottoTicket lottoTicket = new LottoTicket(3000);
        int quantity = lottoTicket.getPurchaseQuantity();
        assertThat(quantity).isEqualTo(3);
    }
}
