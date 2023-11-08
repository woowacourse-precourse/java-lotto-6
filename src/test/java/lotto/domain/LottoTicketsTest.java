package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketsTest {
    private static final int ticketAmount = 5;

    @DisplayName("로또 개수만큼 로또 티켓을 발행한다.")
    @Test
    void createLottoTickets() {
        LottoTickets lottoTickets = new LottoTickets(ticketAmount);

        assertEquals(lottoTickets.getLottoTickets().size(), ticketAmount);
    }
}
