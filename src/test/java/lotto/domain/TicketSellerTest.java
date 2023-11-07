package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TicketSellerTest {

    class ManualLottoGenerator implements LottoGenerator {
        @Override
        public Lotto generate() {
            return new Lotto(List.of(1, 2, 3, 4, 5, 6));
        }
    }
    @DisplayName("티켓이 올바르게 생성되는지 확인한다.")
    @Test
    void createTicket() {
        TicketSeller ticketSeller = new TicketSeller(new ManualLottoGenerator());
        Ticket ticket = ticketSeller.createTicket();
        assertThat(ticket.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
