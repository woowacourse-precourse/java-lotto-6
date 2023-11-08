package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    @DisplayName("로또 티켓 발행")
    @Test
    void createLottoTickets() {
        Money money = new Money(1_000);
        LottoTickets lottoTickets = new LottoTickets(money);

        assertEquals(1, lottoTickets.getLottoTickets().size());
    }
}