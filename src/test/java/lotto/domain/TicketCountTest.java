package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TicketCountTest {
    @Test
    void testGetTicketCount() {
        int purchaseMoney = 5000;
        TicketCount ticketCount = new TicketCount(purchaseMoney);

        int count = ticketCount.getTicketCount();

        assertEquals(5, count);
    }

    @Test
    void testInvalidAmountUnit() {
        int purchaseMoney = 1500;

        assertThrows(IllegalArgumentException.class, () -> new TicketCount(purchaseMoney));
    }
}
