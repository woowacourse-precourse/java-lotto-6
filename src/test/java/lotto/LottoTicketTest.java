package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.PurchasePrice;
import lotto.model.lotto.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {
    @DisplayName("로또 수량은 금액/로또_금액 이어야 한다.")
    @Test
    void createLottoTicketTest(){
        PurchasePrice price = new PurchasePrice(3000);
        LottoTicket lottoTicket = new LottoTicket(price);
        assertThat(lottoTicket.getLottoTicketSize()).isEqualTo(3);
    }

}
