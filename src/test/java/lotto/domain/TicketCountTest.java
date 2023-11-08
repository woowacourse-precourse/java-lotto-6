package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TicketCountTest {

    @DisplayName("PurchaseAmount/1000 수량만큼 생성되는지")
    @Test
    void createBy5000() {
        TicketCount ticketCount = TicketCount.create(PurchaseAmount.create(5000));
        assertEquals(5, ticketCount.getTicketCount());
    }
}
