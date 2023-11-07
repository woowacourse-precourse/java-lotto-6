package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TicketTest {
    @DisplayName("티켓의 생성자는 Lotto와 동일하다.")
    @Test
    void createTicket() {
        assertThatThrownBy(() -> new Ticket(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
