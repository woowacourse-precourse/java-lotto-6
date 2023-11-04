package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    public void 구입_금액이_로또_표_값보다_적으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Player().buyLottoTickets(900))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 구입_금액이_나누어떨어지지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Player().buyLottoTickets(1900))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 로또_티켓을_주어진_개수만큼_구매하는가() {
        //given
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();

        //when
        player1.buyLottoTickets(1000);
        player2.buyLottoTickets(2000);
        player3.buyLottoTickets(3000);

        //then
        assertEquals(1, player1.getTicketCount());
        assertEquals(2, player2.getTicketCount());
        assertEquals(3, player3.getTicketCount());
    }
}
