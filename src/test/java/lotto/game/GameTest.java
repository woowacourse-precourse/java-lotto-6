package lotto.game;

import lotto.domain.Ticket;
import lotto.type.ErrorCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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

    @Test
    @DisplayName("구매한 로또 티켓 수 만큼 티켓(서로다른 숫자 6개)을 만들어 반환한다")
    void getTicketsTest() {
        //given
        int totalTicketCount = 5;
        //when
        Game game = new Game();
        int ticketsCount = game.getTickets(totalTicketCount).size();
        //then
        assertEquals(5, ticketsCount);
    }

    @Test
    @DisplayName("선택한 당첨 번호가 서로 다른 6개의 숫자인지 확인한다.")
    void validateLuckyNumbersTest() {
        //given
        List<String> numberInput = new ArrayList<>(List.of("1", "2", "3", "4", "5", "5"));
        //when
        Game game = new Game();
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class
                , () -> game.validateLuckyNumbers(numberInput));
        //then
        assertThat(e.getMessage()).isEqualTo(ErrorCode.INVALID_LUCKY_NUMBERS.getDescription());
    }

}