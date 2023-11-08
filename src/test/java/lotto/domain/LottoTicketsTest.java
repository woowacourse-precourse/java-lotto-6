package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    @Test
    void 구매_개수만큼_로또티켓_발행() {
        Money money = new Money("1000");
        LottoTickets lottoTickets = new LottoTickets(money);

        assertEquals(1, lottoTickets.getLottoTickets().size());
    }
}