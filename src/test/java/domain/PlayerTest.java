package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    public void 로또_티켓을_주어진_개수만큼_구매하는가() {
        //given
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();

        //when
        player1.buyLottoTickets(1);
        player2.buyLottoTickets(2);
        player3.buyLottoTickets(3);

        //then
        assertEquals(1, player1.getTicketCount());
        assertEquals(2, player2.getTicketCount());
        assertEquals(3, player3.getTicketCount());
    }
}
