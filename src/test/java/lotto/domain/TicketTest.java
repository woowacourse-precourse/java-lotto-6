package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TicketTest {
    @DisplayName("티켓은 로또를 저장한다..")
    @Test
    void createTicket() {
        Lotto lotto = new Lotto(List.of(5, 4, 2, 1, 3, 6));
        Ticket ticket = new Ticket(lotto);

        assertThat(ticket.getNumbers())
                .containsExactly(1, 2, 3, 4, 5, 6);
    }
}
