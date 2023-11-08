package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Ticket의")
class TicketTest {

    @Test
    @DisplayName("ticket이 null값이면 예외를 던지는가")
    void is_null() {
        //given
        final Ticket ticket = new Ticket(null);

        //when & then
        assertThatThrownBy(ticket::toValue).isInstanceOf(IllegalStateException.class);
    }
}
