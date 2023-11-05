package lotto.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicketQuantityTest {

    @DisplayName("TicketQuantity는 필드 값을 포장해야 한다.")
    @Test
    public void quantity_value_test() {
        // given
        Integer quantity = 5;

        // when
        TicketQuantity ticketQuantity = new TicketQuantity(quantity);
        Integer result = ticketQuantity.quantity();

        // then
        assertEquals(result, quantity);
    }

    @DisplayName("두 TickeyQuantity의 필드 값이 동일하면 두 레코드는 동일해야 한다.")
    @Test
    public void quantity_equality_test() {
        // when
        TicketQuantity ticketQuantity1 = new TicketQuantity(1);
        TicketQuantity ticketQuantity2 = new TicketQuantity(1);
        TicketQuantity ticketQuantity3 = new TicketQuantity(2);

        // then
        assertEquals(ticketQuantity1.hashCode(), ticketQuantity2.hashCode());
        assertEquals(ticketQuantity1, ticketQuantity2);
        assertNotEquals(ticketQuantity1, ticketQuantity3);
    }
}
