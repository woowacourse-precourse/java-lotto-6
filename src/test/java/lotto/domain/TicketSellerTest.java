package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TicketSellerTest {
    @DisplayName("티켓이 올바르게 생성되는지 확인한다.")
    @Test
    void createTicket() {
        TicketSeller ticketSeller = new TicketSeller(new ManualLottoGenerator());
        Ticket ticket = ticketSeller.createTicket();
        assertThat(ticket.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
