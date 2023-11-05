package lotto.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicketCountTest {

    @DisplayName("TicketCount는 필드 값을 포장해야 한다.")
    @Test
    public void count_value_test() {
        // given
        Integer count = 5;

        // when
        TicketCount ticketCount = new TicketCount(count);
        Integer result = ticketCount.count();

        // then
        assertEquals(result, count);
    }

    @DisplayName("두 TicketCount의 필드 값이 동일하면 두 레코드는 동일해야 한다.")
    @Test
    public void count_equality_test() {
        // when
        TicketCount ticketCount1 = new TicketCount(1);
        TicketCount ticketCount2 = new TicketCount(1);
        TicketCount ticketCount3 = new TicketCount(2);

        // then
        assertEquals(ticketCount1.hashCode(), ticketCount2.hashCode());
        assertEquals(ticketCount1, ticketCount2);
        assertNotEquals(ticketCount1.hashCode(), ticketCount3.hashCode());
        assertNotEquals(ticketCount1, ticketCount3);
    }
}
