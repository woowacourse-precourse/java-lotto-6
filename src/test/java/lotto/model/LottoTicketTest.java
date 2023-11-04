package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

    @DisplayName("로또 티켓 생성 테스트")
    @Test
    void generateTickets() {
        int ticketCount = 5;

        LottoTickets lottoTickets = LottoTickets.generateTickets(ticketCount);
        List<LottoTicket> tickets = lottoTickets.getTickets();

        assertThat(tickets.size()).isEqualTo(ticketCount);
    }

}