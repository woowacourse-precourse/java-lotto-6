package lotto.game;

import lotto.domain.Ticket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    @DisplayName("구입금액에 따른 구매하는 로또 총 개수를 확인한다.")
    void buyTicketTest() {
        //given
        int moneyInput = 4000;
        Ticket ticket = new Ticket();

        //when
        ticket.setCount(moneyInput);

        //then
        int ticketCount = ticket.getCount();
        assertEquals(4, ticketCount);
    }

}